package com.churchapp.ikon.ikonchurch.amazonaws.mobilehelper.util;
//
// Copyright 2017 Amazon.com, Inc. or its affiliates (Amazon). All Rights Reserved.
//
// Code generated by AWS Mobile Hub. Amazon gives unlimited permission to 
// copy, distribute and modify it.
//
// Source code generated from template: aws-my-sample-app-android v0.18
//

import android.os.Handler;
import android.os.Looper;

public class ThreadUtils {
    private ThreadUtils() {
    }

    /**
     * Run a runnable on the Main (UI) Thread.
     * @param runnable the runnable
     */
    public static void runOnUiThread(final Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(runnable);
        } else {
            runnable.run();
        }
    }
}
