package lab.galaxy.changephoneinfo;

import android.util.Log;

/**
 * Created by liuruikai756 on 17/05/2017.
 */

public class Hook_BluetoothAdapter_getAddress {
    public static String className = "android.bluetooth.BluetoothAdapter";
    public static String methodName = "getAddress";
    public static String methodSig = "()Ljava/lang/String;";
    public static String hook(Object thiz) {
        Log.i("YAHFA", "BluetoothAdapter getAddress hooked");
        return "11:22:33:44:55:66";
    }
}
