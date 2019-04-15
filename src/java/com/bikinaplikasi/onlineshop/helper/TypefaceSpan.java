/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.graphics.Typeface
 *  android.support.v4.util.LruCache
 *  android.text.TextPaint
 *  android.text.style.MetricAffectingSpan
 *  java.lang.Object
 *  java.lang.String
 */
package com.bikinaplikasi.onlineshop.helper;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class TypefaceSpan
extends MetricAffectingSpan {
    private static LruCache<String, Typeface> sTypefaceCache = new LruCache(12);
    private Typeface mTypeface;

    public TypefaceSpan(Context context, String string) {
        this.mTypeface = (Typeface)sTypefaceCache.get((Object)string);
        if (this.mTypeface == null) {
            this.mTypeface = Typeface.createFromAsset((AssetManager)context.getApplicationContext().getAssets(), (String)String.format((String)"%s", (Object[])new Object[]{string}));
            sTypefaceCache.put((Object)string, (Object)this.mTypeface);
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTypeface(this.mTypeface);
        textPaint.setFlags(128 | textPaint.getFlags());
    }

    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTypeface(this.mTypeface);
        textPaint.setFlags(128 | textPaint.getFlags());
    }
}

