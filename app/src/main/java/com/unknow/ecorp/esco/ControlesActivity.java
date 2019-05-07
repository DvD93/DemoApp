package com.unknow.ecorp.esco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ControlesActivity extends AppCompatActivity implements View.OnClickListener {
    //P3
    private Button mButtons;
    private Button mTexts;
    private Button mChecks;
    private Button mSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controles);
    }
    @Override
    public void onResume()
    {
        super.onResume();

        addWidgets();
        addListeners();
    }

    private void addListeners()
    {
        mButtons.setOnClickListener(ControlesActivity.this);
        mTexts.setOnClickListener(ControlesActivity.this);
        mChecks.setOnClickListener(ControlesActivity.this);
        mSalir.setOnClickListener(ControlesActivity.this);
    }

    private void addWidgets()
    {
        mButtons =  findViewById(R.id.main_activity_btnButtons);
        mTexts =  findViewById(R.id.main_activity_btnTexts);
        mChecks =  findViewById(R.id.main_activity_btnCheck);
        mSalir =  findViewById(R.id.main_activity_btnSalir);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch(v.getId())
        {
            case R.id.main_activity_btnButtons:
                intent.setClass(ControlesActivity.this, ButtonsActivity.class);
                break;
            case R.id.main_activity_btnTexts:
                intent.setClass(ControlesActivity.this, TextsActivity.class);
                break;
            case R.id.main_activity_btnCheck:
                intent.setClass(ControlesActivity.this, ChecksRadiosActivity.class);
                break;
            case R.id.main_activity_btnSalir:
                finish();
                return;
        }

        startActivity(intent);
    }
}
