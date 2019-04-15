/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.CursorLoader
 *  android.database.Cursor
 *  android.net.Uri
 *  android.provider.DocumentsContract
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Images
 *  android.provider.MediaStore$Images$Media
 *  java.lang.Object
 *  java.lang.String
 */
package com.bikinaplikasi.onlineshop.helper;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;

public class RealPathUtil {
    @SuppressLint(value={"NewApi"})
    public static String getRealPathFromURI_API11to18(Context context, Uri uri) {
        Cursor cursor = new CursorLoader(context, uri, new String[]{"_data"}, null, null, null).loadInBackground();
        String string = null;
        if (cursor != null) {
            int n = cursor.getColumnIndexOrThrow("_data");
            cursor.moveToFirst();
            string = cursor.getString(n);
        }
        return string;
    }

    @SuppressLint(value={"NewApi"})
    public static String getRealPathFromURI_API19(Context context, Uri uri) {
        String string = "";
        String string2 = DocumentsContract.getDocumentId((Uri)uri).split(":")[1];
        String[] arrstring = new String[]{"_data"};
        Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, arrstring, "_id=?", new String[]{string2}, null);
        int n = cursor.getColumnIndex(arrstring[0]);
        if (cursor.moveToFirst()) {
            string = cursor.getString(n);
        }
        cursor.close();
        return string;
    }

    public static String getRealPathFromURI_BelowAPI11(Context context, Uri uri) {
        String[] arrstring = new String[]{"_data"};
        Cursor cursor = context.getContentResolver().query(uri, arrstring, null, null, null);
        int n = cursor.getColumnIndexOrThrow("_data");
        cursor.moveToFirst();
        return cursor.getString(n);
    }
}

