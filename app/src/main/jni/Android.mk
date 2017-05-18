LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES:= hookprop.c

LOCAL_LDLIBS    := -llog

LOCAL_MODULE:= hookprop

include $(BUILD_SHARED_LIBRARY)
