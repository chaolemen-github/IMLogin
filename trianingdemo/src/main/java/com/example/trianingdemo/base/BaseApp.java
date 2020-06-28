package com.example.trianingdemo.base;

import android.app.Application;

public class BaseApp extends Application {
    public static BaseApp baseApp;

    public BaseApp() {
        baseApp = this;
    }

    public static BaseApp getBaseApp() {
        return baseApp;
    }
}
