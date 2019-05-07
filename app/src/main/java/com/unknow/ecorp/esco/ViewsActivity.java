package com.unknow.ecorp.esco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSpinner;
    private Button mListView;
    private Button mGridView;
    private Button mSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);
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
        mSpinner.setOnClickListener(ViewsActivity.this);
        mListView.setOnClickListener(ViewsActivity.this);
        mGridView.setOnClickListener(ViewsActivity.this);
        mSalir.setOnClickListener(ViewsActivity.this);
    }

    private void addWidgets()
    {
        mSpinner =  findViewById(R.id.main_activity_btnSpinner);
        mListView =  findViewById(R.id.main_activity_btnListView);
        mGridView =  findViewById(R.id.main_activity_btnGridView);
        mSalir =  findViewById(R.id.main_activity_btnSalir);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch(v.getId())
        {
            case R.id.main_activity_btnSpinner:
                intent.setClass(ViewsActivity.this, SpinnerActivity.class);
                break;
            case R.id.main_activity_btnListView:
                intent.setClass(ViewsActivity.this, ListViewActivity.class);
                break;
            case R.id.main_activity_btnGridView:
                intent.setClass(ViewsActivity.this, GridViewActivity.class);
                break;
            case R.id.main_activity_btnSalir:
                finish();
                return;
        }

        startActivity(intent);
    }
}
