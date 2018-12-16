package com.example.deepak.foregroundservice;

import android.annotation.TargetApi;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String CHANNEL1_ID = "ForegroundService";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationsChannel();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void createNotificationsChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(CHANNEL1_ID,
                    "ForegroundService", NotificationManager.IMPORTANCE_DEFAULT);
            channel1.setDescription("ForegroundService 1");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel1);
        }

    }
}
