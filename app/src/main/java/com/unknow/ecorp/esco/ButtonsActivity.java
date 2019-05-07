package com.unknow.ecorp.esco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ButtonsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mMensaje;
    private Button mButton;
    private ImageButton mImageButton;
    private ToggleButton mToggleButton;
    private Button mButtonCI;
    private ToggleButton mToggleButtonCI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);
        addWidgets();
        addListeners();

    }

    private void addListeners()
    {
        mButton.setOnClickListener(this);
        mButtonCI.setOnClickListener(this);
        mImageButton.setOnClickListener(this);
        mToggleButton.setOnClickListener(this);
        mToggleButtonCI.setOnClickListener(this);
    }

    private void addWidgets()
    {
        mMensaje = findViewById(R.id.buttons_activity_tvMensaje);
        mButton = findViewById(R.id.buttons_activity_btnButton);
        mButtonCI = findViewById(R.id.buttons_activity_btnButtonCI);
        mImageButton = findViewById(R.id.buttons_activity_ibtImageButton);
        mToggleButton = findViewById(R.id.buttons_activity_tglToggleButton);
        mToggleButtonCI = findViewById(R.id.buttons_activity_tglToggleButtonCI);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.buttons_activity_btnButton:
                mMensaje.setText("Button 1 pulsado");
                break;
            case R.id.buttons_activity_btnButtonCI:
                mMensaje.setText("Button 4 con imagen pulsado");
                break;
            case R.id.buttons_activity_ibtImageButton:
                mMensaje.setText("ImageButton 2 pulsado");
                break;
            case R.id.buttons_activity_tglToggleButton:
                if(mToggleButton.isChecked())
                    mMensaje.setText("ToggleButton 3 prendido");
                else
                    mMensaje.setText("ToggleButton 3 apagado");
                break;
            case R.id.buttons_activity_tglToggleButtonCI:
                if(mToggleButtonCI.isChecked())
                    mMensaje.setText("ToggleButton 5 customizado prendido");
                else
                    mMensaje.setText("ToggleButton 5 customizado apagado");
                break;
        }

    }
}
