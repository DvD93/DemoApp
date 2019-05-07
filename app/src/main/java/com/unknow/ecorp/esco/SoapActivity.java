package com.unknow.ecorp.esco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SoapActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSumar;
    private Button mTemperatura;
    private Button mPeliculas;
    private Button mSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soap);
        addWidgets();
        addListeners();
    }

    private void addListeners()
    {
        mSumar.setOnClickListener(this);
        mTemperatura.setOnClickListener(this);
        mPeliculas.setOnClickListener(this);
        mSalir.setOnClickListener(this);
    }

    private void addWidgets()
    {
        mSumar = findViewById(R.id.soap_activity_btnSumar);
        mTemperatura =  findViewById(R.id.soap_activity_btnTemperatura);
        mPeliculas =  findViewById(R.id.soap_activity_btnPeliculas);
        mSalir =  findViewById(R.id.soap_activity_btnSalir);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch(v.getId())
        {
            case R.id.soap_activity_btnSumar:
                intent.setClass(this, SoapSumarActivity.class);
                break;
            case R.id.soap_activity_btnTemperatura:
                intent.setClass(this, SoapTemperaturaActivity.class);
                break;
            case R.id.soap_activity_btnPeliculas:
                intent.setClass(this, SoapPeliculasActivity.class);
                break;
            case R.id.soap_activity_btnSalir:
                finish();
                return;
        }

        startActivity(intent);
    }
}
