package com.ach.androidcertf.utils;

import android.content.Context;

import java.util.List;

public class AppUtils {



    public static String getAppPackageName(Context context) {
        return context.getPackageName();
    }



    public static boolean isEmpty(String string){
        return (string == null || string.isEmpty() || "null".equalsIgnoreCase(string));
    }


    public static boolean isEmpty(List list){
        return (list == null || list.isEmpty());
    }


}
