package com.example.shit.opentoktest;

import android.app.Application;
import android.content.Context;

/**
 * Created by 1 on 06.07.2017.
 */

public class App extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent(){
        return appComponent;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }


}
