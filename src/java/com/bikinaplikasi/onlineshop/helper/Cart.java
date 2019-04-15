/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Object
 *  java.lang.String
 */
package com.bikinaplikasi.onlineshop.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class Cart {
    private static final String CART_JSON = "cartJson";
    private static final String PREF_NAME = "bmscrtsv";
    int PRIVATE_MODE = 0;
    Context _context;
    SharedPreferences.Editor editor;
    SharedPreferences pref;

    public Cart(Context context) {
        this._context = context;
        this.pref = this._context.getSharedPreferences(PREF_NAME, this.PRIVATE_MODE);
        this.editor = this.pref.edit();
    }

    public String getCartJson() {
        return this.pref.getString(CART_JSON, null);
    }

    public void setCartJson(String string) {
        this.editor.putString(CART_JSON, string);
        this.editor.commit();
    }
}

