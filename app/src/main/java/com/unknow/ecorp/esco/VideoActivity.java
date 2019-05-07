package com.unknow.ecorp.esco;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    private VideoView mVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        addWidgets();
        setVideo();
    }

    private void setVideo()
    {
        String vidAddress = Environment.getExternalStorageDirectory() + "/trailer.3gp";//"http://techslides.com/demos/sample-videos/small.mp4";
        //Uri vidUri = Uri.parse(vidAddress);
        mVideo.setVideoPath(vidAddress);
        mVideo.start();
    }

    private void addWidgets()
    {
        mVideo = findViewById(R.id.videoView1);
    }
}
