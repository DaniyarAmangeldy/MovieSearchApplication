package msearch.daniyaramangeldy.com.moviesearchapp;

import android.app.Activity;
import android.app.Application;

import dagger.android.AndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.DaggerApplication;
import msearch.daniyaramangeldy.com.moviesearchapp.di.AppModule;
import msearch.daniyaramangeldy.com.moviesearchapp.di.DaggerApplicationComponent;
import msearch.daniyaramangeldy.com.moviesearchapp.di.NetworkModule;

public class App extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent
                .builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;
    }
}
