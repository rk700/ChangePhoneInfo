package lab.galaxy.changephoneinfo;

import android.util.Log;

/**
 * Created by liuruikai756 on 17/05/2017.
 */

public class Hook_WifiInfo_getIpAddress {
    public static String className = "android.net.wifi.WifiInfo";
    public static String methodName = "getIpAddress";
    public static String methodSig = "()I";
    public static int hook(Object thiz) {
        Log.i("YAHFA", "WifiInfo getIpAddress hooked");
        return 666;
    }
}
