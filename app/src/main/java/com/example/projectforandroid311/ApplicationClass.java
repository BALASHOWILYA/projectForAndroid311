package com.example.projectforandroid311;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import androidx.annotation.NonNull;

public class ApplicationClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        long time =  System.currentTimeMillis();
        Log.d("LifeCycleLog", "onCreateApplication: " + time);
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
}
