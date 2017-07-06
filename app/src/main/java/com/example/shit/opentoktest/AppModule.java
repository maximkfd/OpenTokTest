package com.example.shit.opentoktest;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.shit.opentoktest.App;
import com.example.shit.opentoktest.listeners.PublisherListenerImpl;
import com.example.shit.opentoktest.listeners.SessionService;
import com.example.shit.opentoktest.presenter.Presenter;
import com.example.shit.opentoktest.presenter.PresenterImpl;
import com.opentok.android.PublisherKit;
import com.opentok.android.Session;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 1 on 06.07.2017.
 */
@Module
public class AppModule {
    private final App app;
    private final SessionService mSessionService;

    public AppModule(App app) {
        this.app = app;
        this.mSessionService = new SessionService(app);
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return app;
    }


    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application application){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    SessionService provideSessionService(){
        return mSessionService;
    }


    @Provides
    @Singleton
    Presenter providePresenter(){
        return new PresenterImpl();
    }

}

