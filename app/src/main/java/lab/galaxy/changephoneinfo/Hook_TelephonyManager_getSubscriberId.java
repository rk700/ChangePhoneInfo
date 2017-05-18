package lab.galaxy.changephoneinfo;

import android.util.Log;

/**
 * Created by liuruikai756 on 17/05/2017.
 */

public class Hook_TelephonyManager_getSubscriberId {
    public static String className = "android.telephony.TelephonyManager";
    public static String methodName = "getSubscriberId";
    public static String methodSig = "()Ljava/lang/String;";
    public static String hook(Object thiz) {
        Log.i("YAHFA", "TelephonyManager getSubscriberId hooked");
        return "123456789012345";
    }
}
