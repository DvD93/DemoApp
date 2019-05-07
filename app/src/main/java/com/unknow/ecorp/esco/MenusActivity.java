package com.unknow.ecorp.esco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenusActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mMenus;
    private Button mMenusContextuales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
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
        mMenus.setOnClickListener(this);
        mMenusContextuales.setOnClickListener(this);
    }

    private void addWidgets()
    {
        mMenus =  findViewById(R.id.main_activity_btnMenus);
        mMenusContextuales = findViewById(R.id.main_activity_btnMenusContextuales);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch(v.getId())
        {
            case R.id.main_activity_btnMenus:
                intent.setClass(this, MenuActivity.class);
                break;
            case R.id.main_activity_btnMenusContextuales:
                intent.setClass(this, ContextMenusActivity.class);
                break;
            case R.id.menus_activity_btnSalir:
                finish();
                return;

        }

        startActivity(intent);
    }
}
