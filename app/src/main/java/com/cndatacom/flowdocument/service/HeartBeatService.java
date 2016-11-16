package com.cndatacom.flowdocument.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.cndatacom.flowdocument.R;
import com.cndatacom.flowdocument.activity.MainActivity;
import com.cndatacom.flowdocument.receiver.HeartBeatReceiver;

/**
 * Created by staring on 16-11-16.
 */

public class HeartBeatService extends Service {

    private HeartBeatReceiver heartBeatReceiver;
    private final static int FOREGROUND_ID = 1000;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        if (heartBeatReceiver == null) {
            heartBeatReceiver = new HeartBeatReceiver(this);
        }

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(heartBeatReceiver, filter);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Foreground");
        builder.setContentText("你正在使用中国电信流量套餐");
        builder.setContentInfo("Content Info");
        builder.setWhen(System.currentTimeMillis());
        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, activityIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        Notification notification = builder.build();
        startForeground(FOREGROUND_ID, notification);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(heartBeatReceiver);
        super.onDestroy();
    }
}
