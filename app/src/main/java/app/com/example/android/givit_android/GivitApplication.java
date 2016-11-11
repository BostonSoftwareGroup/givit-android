package app.com.example.android.givit_android;

import android.app.Application;

import timber.log.Timber;
public class GivitApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        setupTimber();
    }

    private void setupTimber() {
        Timber.plant(new Timber.DebugTree());
    }
}
