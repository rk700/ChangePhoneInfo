package lab.galaxy.changephoneinfo;

import android.util.Log;

/**
 * Created by liuruikai756 on 17/05/2017.
 */

public class Hook_Location_getLatitude {
    public static String className = "android.location.Location";
    public static String methodName = "getLatitude";
    public static String methodSig = "()D";
    public static double hook(Object thiz) {
        Log.i("YAHFA", "Location getLatitude hooked");
        return 11.0;
    }
}
