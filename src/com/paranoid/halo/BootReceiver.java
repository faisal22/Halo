package com.paranoid.halo;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Utils.getStatus(context)) {
            String[] packages = Utils.loadArray(context);
            if(packages != null) {
                NotificationManager notificationManager =
                        (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                for(String packageName : packages){
                	// Upon boot onReceive, there needs to be a way to retrieve the package's customStatusBarIcon that can be passed to Utils.createNotification as a Package
                	// The best would be to be able to extract this from the packages default status bar icon
                    Utils.createNotification(context, notificationManager, /*packageName and customStatusBarIcon passed to create notification*/ new Package(packageName, R.drawable.ic_status));
                }
            }
        }
    }
}