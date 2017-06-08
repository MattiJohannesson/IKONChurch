package com.churchapp.ikon.ikonchurch.amazonaws.mobilehelper.auth.signin.ui;
//
// Copyright 2017 Amazon.com, Inc. or its affiliates (Amazon). All Rights Reserved.
//
// Code generated by AWS Mobile Hub. Amazon gives unlimited permission to 
// copy, distribute and modify it.
//
// Source code generated from template: aws-my-sample-app-android v0.18
//

import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.DisplayMetrics;

/**
 * A class containing UI Utility methods.
 */
public class DisplayUtils {
    private static final DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
    private static int dpMultiplier = (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);

    /**
     * @param dp number of design pixels.
     * @return number of pixels corresponding to the desired design pixels.
     */
    public static int dp(final int dp) {
        return dp * dpMultiplier;
    }

    /**
     * Create a rounded rectangle with a specified corner radius.
     *
     * @param cornerRadius the corner radius in pixels
     * @return the shape drawable.
     */
    public static Shape getRoundedRectangleShape(int cornerRadius) {

        // Background color for Button.
        return new RoundRectShape(
            new float[]{
                cornerRadius, cornerRadius, cornerRadius, cornerRadius,
                cornerRadius, cornerRadius, cornerRadius, cornerRadius},
            null, null);
    }

    public static ShapeDrawable getRoundedRectangleBackground(int cornerRadius, int backgroundColor) {
        final ShapeDrawable drawable = new ShapeDrawable(
            getRoundedRectangleShape(cornerRadius));
        drawable.getPaint().setColor(backgroundColor);
        return drawable;
    }
}
