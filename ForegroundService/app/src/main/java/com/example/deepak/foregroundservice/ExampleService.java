package com.example.deepak.foregroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import static com.example.deepak.foregroundservice.App.CHANNEL1_ID;

public class ExampleService extends Service {


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra("data");
        Intent intent1 = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent1, 0);
        Notification notification = new NotificationCompat.Builder(this, CHANNEL1_ID)
                .setContentText(input).setContentIntent(pendingIntent)
                .setContentTitle("Example Foreground Service")
                .setSmallIcon(R.mipmap.ic_launcher).build();
        startForeground(1, notification);
        return START_NOT_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
