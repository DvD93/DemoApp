package com.unknow.ecorp.esco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ContextMenusActivity extends AppCompatActivity {

    private TextView mSeleccion;
    private ListView mPeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menus);

        addWidgets();
        addAdapters();

        registerForContextMenu(mPeliculas);
    }

    private void addWidgets()
    {
        mSeleccion =  findViewById(R.id.contextmenus_activity_tvSeleccion);
        mPeliculas =  findViewById(R.id.contextmenus_activity_lvPeliculas);
    }

    private void addAdapters()
    {
        ArrayAdapter<CharSequence> adtPelis = ArrayAdapter.createFromResource(this, R.array.peliculas, android.R.layout.simple_list_item_1);
        mPeliculas.setAdapter(adtPelis);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu_activity, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.CtxLstOpc1:
                mSeleccion.setText("Etiqueta: Opcion 1 pulsada!");
                return true;
            case R.id.CtxLstOpc2:
                mSeleccion.setText("Etiqueta: Opcion 2 pulsada!");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
