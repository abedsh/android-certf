package com.ach.androidcertf.activities;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class ClassTest {


    @Retention(SOURCE)
    @IntDef({NAVIGATION_MODE_STANDARD, NAVIGATION_MODE_LIST, NAVIGATION_MODE_TABS})
    public @interface NavigationMode {}
    public static final int NAVIGATION_MODE_STANDARD = 0;
    public static final int NAVIGATION_MODE_LIST = 1;
    public static final int NAVIGATION_MODE_TABS = 2;



    public  void setNavigationMode(@NavigationMode int mode){

    }

    @NavigationMode
    public int getNavigationMode(){
        return NAVIGATION_MODE_STANDARD;
    }


}
