package com.unknow.ecorp.esco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataBaseActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mHelper;
    private Button mABM;
    private Button mSelect;
    private Button mSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
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
        mHelper.setOnClickListener(DataBaseActivity.this);
        mABM.setOnClickListener(DataBaseActivity.this);
        mSelect.setOnClickListener(DataBaseActivity.this);
        mSalir.setOnClickListener(DataBaseActivity.this);
    }

    private void addWidgets()
    {
        mHelper = findViewById(R.id.main_activity_btnHelper);
        mABM =  findViewById(R.id.main_activity_btnABM);
        mSelect = findViewById(R.id.main_activity_btnSelect);
        mSalir = findViewById(R.id.main_activity_btnSalir);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();

        switch(v.getId())
        {
            case R.id.main_activity_btnHelper:
                intent.setClass(DataBaseActivity.this, HelperActivity.class);
                break;
            case R.id.main_activity_btnABM:
                intent.setClass(DataBaseActivity.this, ABMActivity.class);
                break;
            case R.id.main_activity_btnSelect:
                intent.setClass(DataBaseActivity.this, SelectActivity.class);
                break;
            case R.id.main_activity_btnSalir:
                finish();
                return;
        }

        startActivity(intent);

    }
}
