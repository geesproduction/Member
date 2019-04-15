/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.SpannableString
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.bikinaplikasi.onlineshop.helper;

import android.content.Context;
import android.text.SpannableString;
import com.bikinaplikasi.onlineshop.helper.TypefaceSpan;

public class CustomActionBar {
    Context context;

    public CustomActionBar(Context context) {
        this.context = context;
    }

    public SpannableString setActionBar(String string) {
        SpannableString spannableString = new SpannableString((CharSequence)string);
        spannableString.setSpan((Object)new TypefaceSpan(this.context, this.context.getString(2131623990)), 0, spannableString.length(), 33);
        return spannableString;
    }
}

