/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  com.bikinaplikasi.onlineshop.app.DataPref
 *  com.bikinaplikasi.onlineshop.notification.BaosNotificationOpenedHandler
 *  com.bikinaplikasi.onlineshop.notification.BaosNotificationReceivedHandler
 *  com.onesignal.OneSignal
 *  com.onesignal.OneSignal$Builder
 *  com.onesignal.OneSignal$NotificationOpenedHandler
 *  com.onesignal.OneSignal$NotificationReceivedHandler
 *  com.onesignal.OneSignal$OSInFocusDisplayOption
 *  java.lang.Object
 *  java.lang.String
 */
package com.bikinaplikasi.onlineshop.notification;

import android.app.Application;
import android.content.Context;
import com.bikinaplikasi.onlineshop.app.DataPref;
import com.bikinaplikasi.onlineshop.notification.BaosNotificationOpenedHandler;
import com.bikinaplikasi.onlineshop.notification.BaosNotificationReceivedHandler;
import com.onesignal.OneSignal;

public class BaosApplication
extends Application {
    private static Context context;
    DataPref dataPref;

    public static Context getContext() {
        return context;
    }

    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        OneSignal.startInit((Context)this).setNotificationOpenedHandler((OneSignal.NotificationOpenedHandler)new BaosNotificationOpenedHandler()).setNotificationReceivedHandler((OneSignal.NotificationReceivedHandler)new BaosNotificationReceivedHandler()).inFocusDisplaying(OneSignal.OSInFocusDisplayOption.None).init();
        this.dataPref = new DataPref(context);
        OneSignal.idsAvailable((OneSignal.IdsAvailableHandler)new OneSignal.IdsAvailableHandler(){

            @Override
            public void idsAvailable(String string, String string2) {
                if (string2 != null) {
                    BaosApplication.this.dataPref.setMemberToken(string2);
                }
            }
        });
    }

}

