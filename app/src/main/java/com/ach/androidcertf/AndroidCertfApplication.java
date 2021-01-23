package com.ach.androidcertf;

import android.app.Application;

import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.Branch;

public class AndroidCertfApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Branch.enableDebugMode();
        // Initialize the Branch object
        Branch.getAutoInstance(this);
    }
}
