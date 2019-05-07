package com.unknow.ecorp.esco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ChecksRadiosActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    private CheckBox mCheck;
    private TextView mMensaje;
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checks_radios);

        addWidgets();
        addListeners();
    }

    private void addListeners()
    {
        mCheck.setOnCheckedChangeListener(this);
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    private void addWidgets()
    {
        mCheck = findViewById (R.id.checks_radios_activity_chkCheck);
        mMensaje =  findViewById (R.id.checks_radios_activity_tvMensaje);
        mRadioGroup =  findViewById (R.id.checks_radios_activity_rbgGroup);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        mMensaje.setText("ID opción seleccionada: " + checkedId);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked)
            mMensaje.setText("Checkbox marcado!");
        else
            mMensaje.setText("Checkbox desmarcado!");
    }
}
