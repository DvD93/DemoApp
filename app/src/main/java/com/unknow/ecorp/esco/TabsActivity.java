package com.unknow.ecorp.esco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

public class TabsActivity extends AppCompatActivity implements TabHost.OnTabChangeListener {

    TabHost mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        addWidgets();
        addListeners();
    }

    private void addListeners()
    {
        mTabs.setOnTabChangedListener(this);
    }

    private void addWidgets()
    {
        mTabs =(TabHost)findViewById(android.R.id.tabhost);
        mTabs.setup();

        TabHost.TabSpec spec=mTabs.newTabSpec("mitab1");
        spec.setContent(R.id.tabs_activity_tab1);
        spec.setIndicator("", getResources().getDrawable(android.R.drawable.ic_btn_speak_now));
        mTabs.addTab(spec);

        spec=mTabs.newTabSpec("mitab2");
        spec.setContent(R.id.tabs_activity_tab2);
        spec.setIndicator("", getResources().getDrawable(android.R.drawable.ic_dialog_map));
        mTabs.addTab(spec);

        mTabs.setCurrentTab(0);
    }

    @Override
    public void onTabChanged(String tabId) {
        Toast.makeText(this, "Pulsada pestaña: " + tabId, Toast.LENGTH_LONG).show();
    }
}
