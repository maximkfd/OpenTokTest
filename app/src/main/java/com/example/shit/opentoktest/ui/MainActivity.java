package com.example.shit.opentoktest.ui;

import android.Manifest;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.shit.opentoktest.App;
import com.example.shit.opentoktest.DaggerAppComponent;
import com.example.shit.opentoktest.R;
import com.example.shit.opentoktest.presenter.Presenter;
import com.opentok.android.PublisherKit;
import com.opentok.android.Session;

import javax.inject.Inject;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements ViewContract{
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int RC_SETTINGS_SCREEN_PERM = 123;
    private static final int RC_VIDEO_APP_PERM = 124;


    private FrameLayout mPublisherViewContainer;
    private FrameLayout mSubscriberViewContainer;

    @Inject
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerAppComponent.builder()
                .build().inject(this);

        presenter.requestPermissions();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void permissionsGranted() {

    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void setPublisherSource(View view) {
        mPublisherViewContainer.addView(view);
    }

    @Override
    public void dropView() {
        mPublisherViewContainer.removeAllViews();
    }

    @Override
    public void updateSubscriberSource(View view) {
        mSubscriberViewContainer.addView(view);
    }
}
