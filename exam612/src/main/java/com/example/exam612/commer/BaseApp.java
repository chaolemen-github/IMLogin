package com.example.exam612.commer;

import android.app.Application;

public class BaseApp extends Application {
    private static BaseApp app;

    public BaseApp() {
        app = this;
    }

    public static BaseApp getApp() {
        return app;
    }
}
