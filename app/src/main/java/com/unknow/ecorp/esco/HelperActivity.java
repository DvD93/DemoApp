package com.unknow.ecorp.esco;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelperActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mMensaje;
    private Button mCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);
        addWidgets();
        addListeners();
    }

    private void addWidgets()
    {
        mMensaje = findViewById(R.id.helper_activity_tvMensaje);
        mCrear = findViewById(R.id.helper_activity_btnCrear);
    }

    private void addListeners()
    {
        mCrear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        crearDB();
    }
    private void crearDB()
    {
        PeliculasSQLiteHelper pelisHelper = new PeliculasSQLiteHelper(this, "DBPeliculas", null, 1);

        SQLiteDatabase db = pelisHelper.getWritableDatabase();

        if(db != null)
        {
            mMensaje.setText("Base de datos creada!!");
            db.close();
        }
        else
            mMensaje.setText("No se pudo crear la base de datos!!");
    }
}
