package com.example.shit.opentoktest.presenter;

import android.Manifest;
import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.shit.opentoktest.R;
import com.example.shit.opentoktest.listeners.SessionService;
import com.example.shit.opentoktest.ui.MainActivity;
import com.example.shit.opentoktest.ui.ViewContract;
import com.opentok.android.OpentokError;
import com.opentok.android.Publisher;
import com.opentok.android.PublisherKit;
import com.opentok.android.Session;
import com.opentok.android.Stream;
import com.opentok.android.Subscriber;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by 1 on 06.07.2017.
 */

public class PresenterImpl implements Presenter {

    private static final String LOG_TAG = PresenterImpl.class.getSimpleName();
    private static String API_KEY ;
    private static String SESSION_ID;
    private static String TOKEN;

    private static final int RC_SETTINGS_SCREEN_PERM = 123;
    private static final int RC_VIDEO_APP_PERM = 124;


    private Session mSession;
    private Publisher mPublisher;
    private Subscriber mSubscriber;

    @Override
    @AfterPermissionGranted(RC_VIDEO_APP_PERM)
    public void requestPermissions() {
        String[] perms = { Manifest.permission.INTERNET, Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO };
        if (EasyPermissions.hasPermissions(mViewContract.getContext(), perms)) {
//            // initialize view objects from your layout
//            mPublisherViewContainer = (FrameLayout)findViewById(R.id.publisher_container);
//            mSubscriberViewContainer = (FrameLayout)findViewById(R.id.subscriber_container);
            mViewContract.permissionsGranted();


            // initialize and connect to the session
            presenter.fetchData();
        } else {
            EasyPermissions.requestPermissions(mViewContract.getContext(), "This app needs access to your camera and mic to make video calls", RC_VIDEO_APP_PERM, perms);
        }
    }

    private ViewContract mViewContract;

    @Inject
    SessionService sessionService;

    @Inject
    Application application;

    @Override
    public void fetchData() {
        sessionService.fetchSessionConnectionData();
    }

    @Override
    public void inject(ViewContract viewContract) {
        mViewContract = viewContract;
    }


    public void newSubscriber(View view){
        mViewContract.setPublisherSource(view);
    }

    public void dropView() {
        mViewContract.dropView();
    }

    public void streamReceived(View view) {
        mViewContract.updateSubscriberSource(view);
    }
}
