package com.unknow.ecorp.esco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MediaActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mFotos;
    private Button mSonidos;
    private Button mMusica;
    private Button mVideo;
    private Button mSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        addWidgets();
        addListeners();
    }

    private void addListeners()
    {
        mFotos.setOnClickListener(MediaActivity.this);
        mSonidos.setOnClickListener(MediaActivity.this);
        mMusica.setOnClickListener(MediaActivity.this);
        mVideo.setOnClickListener(MediaActivity.this);
        mSalir.setOnClickListener(MediaActivity.this);
    }

    private void addWidgets()
    {
        mFotos = findViewById(R.id.main_activity_btnFotos);
        mSonidos = findViewById(R.id.main_activity_btnSonidos);
        mMusica = findViewById(R.id.main_activity_btnMusica);
        mVideo = findViewById(R.id.main_activity_btnVideo);
        mSalir = findViewById(R.id.main_activity_btnSalir);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch(v.getId())
        {
            case R.id.main_activity_btnFotos:
                intent.setClass(MediaActivity.this, FotosActivity.class);
                break;
            case R.id.main_activity_btnSonidos:
               intent.setClass(MediaActivity.this, SonidosActivity.class);
                break;
            case R.id.main_activity_btnMusica:
                intent.setClass(MediaActivity.this, MusicaActivity.class);
                break;
            case R.id.main_activity_btnVideo:
               intent.setClass(MediaActivity.this, VideoActivity.class);
                break;
            case R.id.main_activity_btnSalir:
                finish();
                return;
        }

        startActivity(intent);
    }
}
