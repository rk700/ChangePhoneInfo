package lab.galaxy.changephoneinfo;

import android.util.Log;

/**
 * Created by liuruikai756 on 17/05/2017.
 */

public class Hook_WifiInfo_getMacAddress {
    public static String className = "android.net.wifi.WifiInfo";
    public static String methodName = "getMacAddress";
    public static String methodSig = "()Ljava/lang/String;";
    public static String hook(Object thiz) {
        Log.i("YAHFA", "WifiInfo getMacAddress hooked");
        return "00:22:33:44:55:66";
    }
}
