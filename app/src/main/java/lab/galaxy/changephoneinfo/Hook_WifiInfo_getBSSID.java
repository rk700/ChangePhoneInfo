package lab.galaxy.changephoneinfo;

import android.util.Log;

/**
 * Created by liuruikai756 on 17/05/2017.
 */

public class Hook_WifiInfo_getBSSID {
    public static String className = "android.net.wifi.WifiInfo";
    public static String methodName = "getBSSID";
    public static String methodSig = "()Ljava/lang/String;";
    public static String hook(Object thiz) {
        Log.i("YAHFA", "WifiInfo getBSSID hooked");
        return "22:22:33:44:55:66";
    }
}
