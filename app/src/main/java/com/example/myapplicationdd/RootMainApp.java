package com.example.myapplicationdd;

import android.app.Application;
import android.os.StrictMode;

public class RootMainApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            initStrictMode();
        }
    }
    private void  initStrictMode() {
        StrictMode.setThreadPolicy(
                new StrictMode.ThreadPolicy.Builder()
                        .detectDiskWrites()
                        .detectNetwork()
                        .penaltyLog()
                        .penaltyDeathOnNetwork()
                        .build()
        );
    }
    }
