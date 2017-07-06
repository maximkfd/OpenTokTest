package com.example.shit.opentoktest;

import com.example.shit.opentoktest.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 1 on 06.07.2017.
 */

@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
