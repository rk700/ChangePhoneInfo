package lab.galaxy.changephoneinfo;

import android.util.Log;

/**
 * Created by liuruikai756 on 17/05/2017.
 */

public class Hook_TelephonyManager_getLine1Number {
    public static String className = "android.telephony.TelephonyManager";
    public static String methodName = "getLine1Number";
    public static String methodSig = "()Ljava/lang/String;";
    public static String hook(Object thiz) {
        Log.i("YAHFA", "TelephonyManager getLine1Number hooked");
        return "13666666666";
    }
}
