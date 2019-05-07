package com.unknow.ecorp.esco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private static final int MNU_OPC1 = 1;
    private static final int MNU_OPC2 = 2;
    private static final int MNU_OPC3 = 3;

    private TextView mMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public void onResume()
    {
        super.onResume();

        addWidgets();
    }

    private void addWidgets()
    {
        mMensaje =  findViewById(R.id.menus_activity_tvMensaje);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //Alternativa 1
//	    getMenuInflater().inflate(R.menu.menu_activity, menu);

        //Alternativa 2
//	    menu.add(Menu.NONE, MNU_OPC1, Menu.NONE, "Opcion1").setIcon(android.R.drawable.ic_menu_preferences);
//	    menu.add(Menu.NONE, MNU_OPC2, Menu.NONE, "Opcion2").setIcon(android.R.drawable.ic_menu_compass);
//	    menu.add(Menu.NONE, MNU_OPC3, Menu.NONE, "Opcion3").setIcon(android.R.drawable.ic_menu_agenda);

        //Alternativa 3
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.MnuOpc1:
                mMensaje.setText("Opcion 1 pulsada!");
                return true;
            case R.id.MnuOpc2:
                mMensaje.setText("Opcion 2 pulsada!");
                return true;
            case R.id.MnuOpc3:
                mMensaje.setText("Opcion 3 pulsada!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
