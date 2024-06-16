package com.example.projectforandroid311;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ApplicationClass extends Application {

    public  static  final  String CHANNEL_ID = "channel 1";
    @Override
    public void onCreate() {
        super.onCreate();

        long time =  System.currentTimeMillis();
        Log.d("LifeCycleLog", "onCreateApplication: " + time);
        createNotificationChannel();
    }

    private void createNotificationChannel() {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                        CHANNEL_ID,
                        "Service Channel",
                        NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            if(manager != null) {
                manager.createNotificationChannel(serviceChannel);
            }
        }

    }



    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        long time =  System.currentTimeMillis();
        Log.d("LifeCycleLog", "onConfigurationChangedApplication: " + time);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        long time =  System.currentTimeMillis();
        Log.d("LifeCycleLog", "onLowMemoryApplication: " + time);
    }


    public static class NotificationBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            sendNotification(context);
        }

        private void sendNotification(Context context){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setSmallIcon(R.drawable.img_1)
                    .setContentTitle("Saint-Petersburg")
                    .setContentText("Beautiful city, check this out")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setAutoCancel(true);

            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
            notificationManagerCompat.notify(1, builder.build());

        }
    }

}


