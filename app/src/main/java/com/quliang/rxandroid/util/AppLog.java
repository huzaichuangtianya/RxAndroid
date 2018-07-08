package com.quliang.rxandroid.util;

import android.util.Log;

/**
 * @author quliang
 * @version 2015-8-20 上午11:28:11
 *          desc
 */
public class AppLog {
    private static String  LOG           = "rxAndroid";
    private static boolean switchSetting = true;

    public static void D(String s) {
        if (switchSetting)
            Log.i(LOG, s);
    }
}
