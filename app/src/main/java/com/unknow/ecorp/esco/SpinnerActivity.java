package com.unknow.ecorp.esco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView mMensaje;
    private Spinner mDias;
    private Spinner mMeses;

    private String[] marrMeses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        addWidgets();
        addAdapters();
        addListeners();
    }

    private void addAdapters()
    {
        ArrayAdapter<CharSequence> adtDias = ArrayAdapter.createFromResource(this, R.array.dias, android.R.layout.simple_spinner_item);
        adtDias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mDias.setAdapter(adtDias);

        marrMeses = new String[]{"Enero","Febrero","Marzo","Abril","Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};

        ArrayAdapter<String> adtMeses = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, marrMeses);
        mMeses.setAdapter(adtMeses);
    }

    private void addListeners()
    {
        mDias.setOnItemSelectedListener(this);
        mMeses.setOnItemSelectedListener(this);
    }

    private void addWidgets()
    {
        mMensaje = findViewById(R.id.spinner_activity_tvMensaje);
        mDias =  findViewById(R.id.spinner_activity_spnDias);
        mMeses =  findViewById(R.id.spinner_activity_spnMeses);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.spinner_activity_spnDias)
            mMensaje.setText(parent.getItemAtPosition(position).toString());
        else if(parent.getId() == R.id.spinner_activity_spnMeses)
            mMensaje.setText(marrMeses[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
