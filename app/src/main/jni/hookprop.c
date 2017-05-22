#include "jni.h"
#include <android/log.h>
#include <dlfcn.h>
#include <stddef.h>
#include <string.h>

#define LOG_TAG "ChangePhoneInfo"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN,LOG_TAG,__VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

typedef void (*MSHookType)(void *symbol, void *replace, void **result);
//typedef void *(*propertyFindType)(const char *name);
//typedef int (*propertyReadType)(const void *pi, char *name, char *value);

//static propertyFindType propertyFind;
//static propertyReadType propertyRead;

typedef struct {
    const char *key;
    const char *value;
} Prop;

static Prop props [] = {
    {"ro.serialno", "1234567890"},
    {"ro.product.brand", "foo"},
    {"ro.product.device", "bar"},
    {"ro.build.tags", "release-keys"},
    {"ro.product.model", "foo"},
    {"ro.product.manufacturer", "bar"}
};

static int propLen = sizeof(props)/sizeof(Prop);

static void *findSymbol(const char *path, const char *symbol) {
    void *handle = dlopen(path, RTLD_LAZY);
    if(!handle) {
        LOGE("handle %s is null", path);
        return NULL;
    }

    //Cydia::MSHookFunction(void *,void *,void **)
    void *target = dlsym(handle, symbol);
    if(!target) {
        LOGE("symbol %s is null", symbol);
    }
    return target;
}

/*
// Here I have to implement the original method instead of backup
// See http://rk700.github.io/2017/05/18/x86-inline-hook-mistake/ for reason
// Update: no longer needed since get_pc_thunk support is added to VirtualHook
static int origin_property_get(const char *name, char *value) {
    void *pi = propertyFind(name);
    if(pi != NULL) {
        int res = propertyRead(pi, NULL, value);
        return res;
    }
    else {
        value[0] = 0;
        return 0;
    }
}
*/

static int (*old_property_get)(const char *name, char *value);


static int new_property_get(const char *name, char *value) {

    for(int i=0; i<propLen; i++) {
        Prop *prop = &props[i];
        if(!strcmp(prop->key, name)) {
            size_t valueLen = strlen(prop->value);
            // Hope there'd be no overflow here!
            strcpy(value, prop->value);
            return valueLen;
        }
    }
    return old_property_get(name, value);
}


static void doHook() {
    MSHookType hookFunc;
    // Cydia::MSHookFunction
    hookFunc = findSymbol("libva-native.so", "_ZN5Cydia14MSHookFunctionEPvS0_PS0_");
    void *target = findSymbol("libc.so", "__system_property_get");
    if(!hookFunc || !target) {
        LOGE("cannot hook __system_property_get: MSHookFunction %p, __system_property_get %p",
             hookFunc, target);
        return;
    }

    /*
    propertyRead = (propertyReadType)findSymbol("libc.so", "__system_property_read");
    propertyFind = (propertyFindType)findSymbol("libc.so", "__system_property_find");

    if(!propertyRead || !propertyFind) {
        LOGE("cannot find propertyFind and propertyRead: %p, %p", propertyRead, propertyFind);
        return;
    }
     */

    hookFunc(target, (void *)&new_property_get, (void **)&old_property_get);
}



jint JNI_OnLoad(JavaVM* vm, void* reserved) {
    JNIEnv* env;
    if ((*vm)->GetEnv(vm, (void**) &env, JNI_VERSION_1_6) != JNI_OK) {
        return -1;
    }
    doHook();
    LOGI("native hook done");
    return JNI_VERSION_1_6;
}