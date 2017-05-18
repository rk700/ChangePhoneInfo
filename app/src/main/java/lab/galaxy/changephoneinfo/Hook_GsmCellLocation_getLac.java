package lab.galaxy.changephoneinfo;

import android.util.Log;

/**
 * Created by liuruikai756 on 17/05/2017.
 */

public class Hook_GsmCellLocation_getLac {
    public static String className = "android.telephony.gsm.GsmCellLocation";
    public static String methodName = "getLac";
    public static String methodSig = "()I";
    public static int hook(Object thiz) {
        Log.i("YAHFA", "GsmCellLocation getLac hooked");
        return 123;
    }
}
