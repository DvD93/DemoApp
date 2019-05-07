package com.unknow.ecorp.esco;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResponseActivity extends AppCompatActivity implements View.OnClickListener {

    //P1
    public static String nombre = "nombre";
    public static String apellido = "apellido";
    public static String email = "";
    public static String telefono = "";


    private TextView mRespuesta;
    private Button mMensaje;


    //P2
    private Button mFrame;
    private Button mLinear;
    private Button mTable;
    private Button mRelative;
    private Button mSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
    }


    //P1

    @Override
    public void onResume()
    {
        super.onResume();
        addWidgets();
        addListeners();
        setData();
    }


    private void addWidgets()
    {
        mRespuesta = findViewById(R.id.response_activity_tvResponse);
        mFrame = findViewById(R.id.btnFrame);
        mLinear = findViewById(R.id.btnLinear);
        mTable =  findViewById(R.id.btnTable);
        mRelative =  findViewById(R.id.btnRelative);
        mSalir =  findViewById(R.id.btnSalir);
    }

    private void setData()
    {
        String data = this.getIntent().getStringExtra(nombre);


        mRespuesta.setText("Hola " + data);
    }

    //P2
    private void addListeners()
    {
        mFrame.setOnClickListener(ResponseActivity.this);
        mLinear.setOnClickListener(ResponseActivity.this);
        mTable.setOnClickListener(ResponseActivity.this);
        mRelative.setOnClickListener(ResponseActivity.this);
        mSalir.setOnClickListener(ResponseActivity.this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch(v.getId())
        {
            case R.id.btnFrame:
                intent.setClass(ResponseActivity.this, FrameLayout.class);
                break;
            case R.id.btnLinear:
                intent.setClass(ResponseActivity.this, LinearLayout.class);
                break;
            case R.id.btnTable:
                intent.setClass(ResponseActivity.this, TableLayout.class);
                break;
            case R.id.btnRelative:
                intent.setClass(ResponseActivity.this, RelativeLayout.class);
                break;
            case R.id.btnSalir:
                finish();
                return;
        }

        startActivity(intent);
    }
}
