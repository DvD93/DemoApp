package com.unknow.ecorp.esco;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MusicaActivity extends AppCompatActivity implements View.OnClickListener {

    private static int TIEMPO = 5000;

    private ImageButton mReproducir;
    private ImageButton mPausar;
    private ImageButton mAvanzar;
    private ImageButton mRetroceder;
    private TextView mReproduciendo;
    private MediaPlayer mPlayer;
    private SeekBar mSeekBar;

    private final Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);
        addWidgets();
        addListeners();
        setPlayer();
    }

    private void addWidgets()
    {
        mReproducir = findViewById(R.id.musica_activity_imbReproducir);
        mPausar = findViewById(R.id.musica_activity_imbPausar);
        mAvanzar =  findViewById(R.id.musica_activity_imbAvanzar);
        mRetroceder = findViewById(R.id.musica_activity_imbRetroceder);
        mReproduciendo =  findViewById(R.id.musica_activity_tvReproduciendo);
        mSeekBar = findViewById(R.id.musica_activity_skbSeekBar);
    }

    private void addListeners()
    {
        mReproducir.setOnClickListener(this);
        mPausar.setOnClickListener(this);
        mAvanzar.setOnClickListener(this);
        mRetroceder.setOnClickListener(this);
    }

    private void setPlayer()
    {
        mPlayer = MediaPlayer.create(this, R.raw.lake_of_fire);
        mSeekBar.setMax(mPlayer.getDuration());
        mReproduciendo.setText(R.string.lake_of_fire);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.musica_activity_imbReproducir:
                reproducir();
                break;
            case R.id.musica_activity_imbPausar:
                pausar();
                break;
            case R.id.musica_activity_imbAvanzar:
                avanzar();
                break;
            case R.id.musica_activity_imbRetroceder:
                retroceder();
                break;
        }

    }

    private void retroceder()
    {
        if((mPlayer.getCurrentPosition() - TIEMPO) > 0)
        {
            mPlayer.seekTo(mPlayer.getCurrentPosition() - TIEMPO);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "No se puede avanzar", Toast.LENGTH_SHORT).show();
        }
    }

    private void avanzar()
    {
        if((mPlayer.getCurrentPosition() + TIEMPO) <= mPlayer.getDuration())
        {
            mPlayer.seekTo(mPlayer.getCurrentPosition() + TIEMPO);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "No se puede avanzar", Toast.LENGTH_SHORT).show();
        }
    }

    private void pausar()
    {
        Toast.makeText(getApplicationContext(), "Pausado", Toast.LENGTH_SHORT).show();

        mPlayer.pause();
        mPausar.setEnabled(false);
        mReproducir.setEnabled(true);
    }

    private void reproducir()
    {
        Toast.makeText(getApplicationContext(), "Reproduciendo MP3", Toast.LENGTH_SHORT).show();
        mPlayer.start();

        mSeekBar.setMax((int) mPlayer.getDuration());

        mSeekBar.setProgress(0);
        mHandler.postDelayed(UpdateSongTime,100);
        mPausar.setEnabled(true);
        mReproducir.setEnabled(false);
    }

    private Runnable UpdateSongTime = new Runnable()
    {
        public void run()
        {
            if(mPlayer != null)
            {
                mSeekBar.setProgress(mPlayer.getCurrentPosition());
                mHandler.postDelayed(this, 100);
            }
        }
    };

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        if (mPlayer != null)
        {
            mPlayer.release();
            mPlayer = null;
        }

    }
}
