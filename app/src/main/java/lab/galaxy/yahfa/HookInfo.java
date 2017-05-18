package lab.galaxy.yahfa;

/**
 * Created by liuruikai756 on 17/05/2017.
 */

public class HookInfo {
    static {
        System.loadLibrary("hookprop");
    }

    public static String[] hookItemNames = {
        "lab.galaxy.changephoneinfo.Hook_GsmCellLocation_getCid",
        "lab.galaxy.changephoneinfo.Hook_GsmCellLocation_getLac",
        "lab.galaxy.changephoneinfo.Hook_BluetoothAdapter_getAddress",
        "lab.galaxy.changephoneinfo.Hook_TelephonyManager_getSimOperator",
        "lab.galaxy.changephoneinfo.Hook_TelephonyManager_getLine1Number",
        "lab.galaxy.changephoneinfo.Hook_TelephonyManager_getDeviceId",
        "lab.galaxy.changephoneinfo.Hook_TelephonyManager_getSubscriberId",
        "lab.galaxy.changephoneinfo.Hook_TelephonyManager_getSimSerialNumber",
        "lab.galaxy.changephoneinfo.Hook_Location_getLatitude",
        "lab.galaxy.changephoneinfo.Hook_Location_getLongitude",
        "lab.galaxy.changephoneinfo.Hook_WifiInfo_getBSSID",
        "lab.galaxy.changephoneinfo.Hook_WifiInfo_getSSID",
        "lab.galaxy.changephoneinfo.Hook_WifiInfo_getIpAddress",
        "lab.galaxy.changephoneinfo.Hook_WifiInfo_getMacAddress"
    };
}
