package com.example.shit.opentoktest.listeners;

import android.util.Log;

import com.opentok.android.OpentokError;
import com.opentok.android.PublisherKit;
import com.opentok.android.Stream;

/**
 * Created by 1 on 06.07.2017.
 */

public class PublisherListenerImpl implements PublisherKit.PublisherListener {

    private static final String LOG_TAG = PublisherKit.PublisherListener.class.getSimpleName();

    @Override
    public void onStreamCreated(PublisherKit publisherKit, Stream stream) {
        Log.i(LOG_TAG, "Publisher onStreamCreated");
    }

    @Override
    public void onStreamDestroyed(PublisherKit publisherKit, Stream stream) {
        Log.i(LOG_TAG, "Publisher onStreamDestroyed");
    }

    @Override
    public void onError(PublisherKit publisherKit, OpentokError opentokError) {
        Log.e(LOG_TAG, "Publisher error: " + opentokError.getMessage());
    }
}
