/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  java.lang.Math
 *  java.lang.Object
 */
package com.bikinaplikasi.onlineshop.helper;

import android.graphics.Color;

public class Design {
    public static int manipulateColor(int n, float f) {
        int n2 = Color.alpha((int)n);
        int n3 = Math.round((float)(f * (float)Color.red((int)n)));
        int n4 = Math.round((float)(f * (float)Color.green((int)n)));
        int n5 = Math.round((float)(f * (float)Color.blue((int)n)));
        return Color.argb((int)n2, (int)Math.min((int)n3, (int)255), (int)Math.min((int)n4, (int)255), (int)Math.min((int)n5, (int)255));
    }

    public int lightenColor(int n) {
        return Design.manipulateColor(n, 1.8f);
    }
}

