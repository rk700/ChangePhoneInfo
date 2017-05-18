package lab.galaxy.changephoneinfo;

import android.util.Log;

/**
 * Created by liuruikai756 on 17/05/2017.
 */

public class Hook_Location_getLongitude {
    public static String className = "android.location.Location";
    public static String methodName = "getLongitude";
    public static String methodSig = "()D";
    public static double hook(Object thiz) {
        Log.i("YAHFA", "Location getLongitude hooked");
        return 22.0;
    }
}
