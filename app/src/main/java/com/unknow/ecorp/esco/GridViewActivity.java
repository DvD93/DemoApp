package com.unknow.ecorp.esco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class GridViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] datos = new String[25];
    private GridView mOpciones;
    private TextView mLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        addWidgets();
        addAdapters();
        addListeners();
    }

    private void addWidgets()
    {
        mLabel = findViewById(R.id.gridview_activity_tvLabel);
        mOpciones =  findViewById(R.id.gridview_activity_grdOpciones);
    }

    private void addAdapters()
    {
        for(int i=1; i<=25; i++)
            datos[i-1] = "Dato " + i;

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        mOpciones.setAdapter(adaptador);
    }

    private void addListeners()
    {
        mOpciones.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mLabel.setText("Opción seleccionada: " + datos[position]);
    }
}
