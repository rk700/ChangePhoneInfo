package lab.galaxy.changephoneinfo;

import android.util.Log;

/**
 * Created by liuruikai756 on 17/05/2017.
 */

public class Hook_WifiInfo_getSSID {
    public static String className = "android.net.wifi.WifiInfo";
    public static String methodName = "getSSID";
    public static String methodSig = "()Ljava/lang/String;";
    public static String hook(Object thiz) {
        Log.i("YAHFA", "WifiInfo getSSID hooked");
        return "666";
    }
}
