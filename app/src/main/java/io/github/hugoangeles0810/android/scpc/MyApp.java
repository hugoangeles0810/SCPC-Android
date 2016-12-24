package io.github.hugoangeles0810.android.scpc;

import android.app.Application;
import android.content.Context;

/**
 * Created by hugo on 24/12/16.
 */

public class MyApp extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
