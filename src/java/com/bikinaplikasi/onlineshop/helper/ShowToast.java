/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.Toast
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.bikinaplikasi.onlineshop.helper;

import android.content.Context;
import android.widget.Toast;

public class ShowToast {
    Context context;

    public ShowToast(Context context) {
        this.context = context;
    }

    public void Toast(String string) {
        Toast.makeText((Context)this.context, (CharSequence)string, (int)1).show();
    }

    public void ToastError() {
        Toast.makeText((Context)this.context, (CharSequence)"Tidak dapat terhubung ke server. Coba lagi nanti.", (int)1).show();
    }
}

