package com.unknow.ecorp.esco;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SonidosActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mCampana;
    private Button mHechizo;
    private Button mMar;
    private Button mMonjes;
    private Button mOveja;
    private Button mRayo;
    private Button mSuegra;
    private Button mSuegro;
    private Button mTambor;
    private Button mVolver;
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonidos);
        addWidgets();
        addListeners();
    }

    private void addWidgets()
    {
        mCampana = findViewById(R.id.sonidos_activity_btnCampana);
        mHechizo = findViewById(R.id.sonidos_activity_btnHechizo);
        mMar = findViewById(R.id.sonidos_activity_btnMar);
        mMonjes =  findViewById(R.id.sonidos_activity_btnMonjes);
        mOveja =  findViewById(R.id.sonidos_activity_btnOveja);
        mRayo =  findViewById(R.id.sonidos_activity_btnRayo);
        mSuegra = findViewById(R.id.sonidos_activity_btnSuegra);
        mSuegro = findViewById(R.id.sonidos_activity_btnSuegro);
        mTambor = findViewById(R.id.sonidos_activity_btnTambor);
        mVolver = findViewById(R.id.sonidos_activity_btnVolver);
    }

    private void addListeners()
    {
        mCampana.setOnClickListener(this);
        mHechizo.setOnClickListener(this);
        mMar.setOnClickListener(this);
        mMonjes.setOnClickListener(this);
        mOveja.setOnClickListener(this);
        mRayo.setOnClickListener(this);
        mSuegra.setOnClickListener(this);
        mSuegro.setOnClickListener(this);
        mTambor.setOnClickListener(this);
        mVolver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.sonidos_activity_btnCampana:
                mPlayer = MediaPlayer.create(this, R.raw.campana);
                break;
            case R.id.sonidos_activity_btnHechizo:
                mPlayer = MediaPlayer.create(this, R.raw.hechizo);
                break;
            case R.id.sonidos_activity_btnMar:
                mPlayer = MediaPlayer.create(this, R.raw.mar);
                break;
            case R.id.sonidos_activity_btnMonjes:
                mPlayer = MediaPlayer.create(this, R.raw.monjes);
                break;
            case R.id.sonidos_activity_btnOveja:
                mPlayer = MediaPlayer.create(this, R.raw.oveja);
                break;
            case R.id.sonidos_activity_btnRayo:
                mPlayer = MediaPlayer.create(this, R.raw.rayo);
                break;
            case R.id.sonidos_activity_btnSuegra:
                mPlayer = MediaPlayer.create(this, R.raw.suegra);
                break;
            case R.id.sonidos_activity_btnSuegro:
                mPlayer = MediaPlayer.create(this, R.raw.suegro);
                break;
            case R.id.sonidos_activity_btnTambor:
                mPlayer = MediaPlayer.create(this, R.raw.tambor);
                break;
            default:
                finish();
                return;
        }

        mPlayer.start();

    }

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
