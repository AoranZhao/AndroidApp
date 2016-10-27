package com.nowansr;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.widget.LinearLayout;
import android.util.Log;
import android.widget.Toast;

import com.opentok.android.Publisher;
import com.opentok.android.PublisherKit;
import com.opentok.android.Session;
import com.opentok.android.Stream;
import com.opentok.android.Subscriber;
import com.opentok.android.SubscriberKit;
import com.opentok.android.OpentokError;

public class VideoActivity extends AppCompatActivity implements Session.SessionListener,
        Publisher.PublisherListener, Subscriber.SubscriberListener,
        Subscriber.VideoListener {

    public static final String API_KEY = "45565282";
    public static final String SESSION_ID = "1_MX40NTU2NTI4Mn5-MTQ2MTI0NDU4ODU2M35VanNVclNHWHdFNVcxZ0d4eWVGVFQ4ZlZ-UH4";
    public static final String TOKEN = "T1==cGFydG5lcl9pZD00NTU2NTI4MiZzaWc9YjQ0NzY0YTZkZmViYjM5MzRhNWFmYmVjZTY2MzdhZTBjZDdmNGY1Yjpyb2xlPXB1Ymxpc2hlciZzZXNzaW9uX2lkPTFfTVg0ME5UVTJOVEk0TW41LU1UUTJNVEkwTkRVNE9EVTJNMzVWYW5OVmNsTkhXSGRGTlZjeFowZDRlV1ZHVkZRNFpsWi1VSDQmY3JlYXRlX3RpbWU9MTQ2MTI0NDYyNCZub25jZT0wLjE1ODg0NTU3MTE5NDI2NzEyJmV4cGlyZV90aW1lPTE0NjM4MzY0NDgmY29ubmVjdGlvbl9kYXRhPQ==";
    public static final String LOGTAG = "MainActivity.class";

    private Session session;
    private LinearLayout publisherView;
    private LinearLayout.LayoutParams publisherParams;
    private LinearLayout subscriberView;
    private LinearLayout.LayoutParams subscriberParams;

    FloatingActionButton btn_stop, btn_mute, btn_mic;

    private Subscriber subscriber;
    private Publisher publisher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        subscriberView = (LinearLayout) findViewById(R.id.video_sub);
        subscriberParams = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        subscriberParams.weight = 0.5f;

        publisherView = (LinearLayout) findViewById(R.id.video_pub);
        publisherParams = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        publisherParams.weight = 0.5f;


        session = new Session(VideoActivity.this, API_KEY, SESSION_ID);
        session.setSessionListener(this);
        session.connect(TOKEN);

        btn_stop = (FloatingActionButton) findViewById(R.id.video_close);
        btn_mute = (FloatingActionButton) findViewById(R.id.video_mute);
        btn_mic = (FloatingActionButton) findViewById(R.id.video_mic);
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                stopVideo();
            }
        });
        btn_mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                muteVideo();
            }
        });
        btn_mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                muteMic();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        session.unsubscribe(subscriber);
        session.unpublish(publisher);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void stopVideo() {
        finish();
    }

    private void muteVideo() {
        Toast.makeText(this, "Mute video", Toast.LENGTH_SHORT).show();
    }

    private void muteMic() {
        Toast.makeText(this, "Mute Mic", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStreamCreated(PublisherKit publisherKit, Stream stream) {
        Log.i(LOGTAG, "call to onStreamCreated of the PublisherListener");
    }

    @Override
    public void onStreamDestroyed(PublisherKit publisherKit, Stream stream) {

    }

    @Override
    public void onError(PublisherKit publisherKit, OpentokError error) {
        Log.i(LOGTAG, "PublisherListener error: " + error.getMessage());

    }

    @Override
    public void onConnected(Session session) {
        Log.i(LOGTAG, "call to onConnected of the SessionListener");
        publisher = new Publisher(VideoActivity.this);
        publisher.setPublisherListener(this);
//        publisherView.addView(publisher.getView(), publisherParams);
        publisherView.addView(publisher.getView());
        session.publish(publisher);
    }

    @Override
    public void onDisconnected(Session session) {
        Log.i(LOGTAG, "call to onDisconnected of the SessionListener");
    }

    @Override
    public void onStreamReceived(Session session, Stream stream) {
        Log.i(LOGTAG, "call to onStreamReceived");
        subscriber = new Subscriber(VideoActivity.this, stream);
        subscriber.setVideoListener(this);
        session.subscribe(subscriber);
//        subscriberView.addView(subscriber.getView(), subscriberParams);
        subscriberView.addView(subscriber.getView());
    }

    @Override
    public void onStreamDropped(Session session, Stream stream) {
        Log.i(LOGTAG, "call to onStreamDropped of the SessionListener");
    }

    @Override
    public void onError(Session session, OpentokError error) {
        Log.i(LOGTAG, "SessionListener error: " + error.getMessage());
    }

    @Override
    public void onConnected(SubscriberKit subscriberKit) {
        Log.i(LOGTAG, "call to onConnected of the SubscriberListener");
    }

    @Override
    public void onDisconnected(SubscriberKit subscriberKit) {
        Log.i(LOGTAG, "call to onDisconnected of the SubscriberListener");
    }

    @Override
    public void onError(SubscriberKit subscriberKit, OpentokError error) {
        Log.i(LOGTAG, "SubscriberListener error: " + error.getMessage());
    }

    @Override
    public void onVideoDataReceived(SubscriberKit subscriberKit) {
        Log.i(LOGTAG, "call to onVideoDataReceived of the VideoListener");
    }

    @Override
    public void onVideoDisabled(SubscriberKit subscriberKit, String s) {
        Log.i(LOGTAG, "call to onVideoDisabled of the VideoListener");
    }

    @Override
    public void onVideoEnabled(SubscriberKit subscriberKit, String s) {
        Log.i(LOGTAG, "call to onVideoEnabled of the VideoListener");
    }

    @Override
    public void onVideoDisableWarning(SubscriberKit subscriberKit) {
        Log.i(LOGTAG, "call to onVideoDisableWarning of the VideoListener");
    }

    @Override
    public void onVideoDisableWarningLifted(SubscriberKit subscriberKit) {
        Log.i(LOGTAG, "call to onVideoDisableWarning of the VideoListener");
    }

}
