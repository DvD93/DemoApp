package com.unknow.ecorp.esco;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import butterknife.OnClick;

public class FormActivity  extends AppCompatActivity implements View.OnClickListener {


    private EditText mNombre;
    private EditText mApellido;
    private EditText mEmail;
    private EditText mTelefono;
    private Switch mTerminos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }
    @Override
    public void onResume()
    {
        super.onResume();

        addWidgets();
    }

    private void addWidgets()
    {
        mNombre = findViewById(R.id.etNombre);
        mApellido = findViewById(R.id.etApellido);
        mEmail = findViewById(R.id.etEmail);
        mTelefono = findViewById(R.id.etTelefono);
        mTerminos = findViewById(R.id.swTerminos);
    }
    @OnClick(R.id.btnGuardar)
    public void SaveData(View view) {


        view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        if (mTerminos.isChecked()) {
            Toast.makeText(this, "Registrando a " +mNombre.getText() + "...", Toast.LENGTH_SHORT).show();

        } else {
            //Si NO tuviera una barra
            //Toast.makeText(this, "Debe aceptar los terminos y condiciones.", Toast.LENGTH_SHORT).show();

            Snackbar.make(view, "Debe aceptar los terminos y condiciones.", Snackbar.LENGTH_LONG)
                    .setAction("OK", new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            mTerminos.setChecked(true);
                        }
                    }).show();

        }
    }

    @Override
    public void onClick(View v) {

    }
}
