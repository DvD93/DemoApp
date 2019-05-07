package com.unknow.ecorp.esco;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class TextsActivity extends AppCompatActivity implements View.OnClickListener {

    public ImageView mContacto;
    public Button mRecargar;
    public TextView mEtiqueta;
    public Button mCambiarColor;
    public EditText mTexto;
    public Button mNegrita;
    public Button mItalic;
    public Button mLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texts);
        addWidget();
        addListeners();
    }

    private void addListeners()
    {
        mRecargar.setOnClickListener(this);
        mCambiarColor.setOnClickListener(this);
        mNegrita.setOnClickListener(this);
        mItalic.setOnClickListener(this);
        mLimpiar.setOnClickListener(this);
    }

    private void addWidget()
    {
        mContacto =  findViewById(R.id.texts_activity_imgContacto);
        mRecargar =  findViewById(R.id.texts_activity_btnRecargar);
        mEtiqueta =  findViewById(R.id.texts_activity_tvLabel);
        mCambiarColor =  findViewById(R.id.texts_activity_btnCambiarColor);
        mTexto =  findViewById(R.id.texts_activity_etTexto);
        mNegrita =  findViewById(R.id.texts_activity_btnNegrita);
        mItalic =  findViewById(R.id.texts_activity_btnItalic);
        mLimpiar =  findViewById(R.id.texts_activity_btnLimpiar);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.texts_activity_btnRecargar:
                recargarImagen();
                break;
            case R.id.texts_activity_btnCambiarColor:
                cambiarColor();
                break;
            case R.id.texts_activity_btnNegrita:
                setNegrita();
                break;
            case R.id.texts_activity_btnLimpiar:
                clean();
                break;
            case R.id.texts_activity_btnItalic:
                setItalic();
                break;
        }
    }

    private void clean()
    {
        Editable str = Editable.Factory.getInstance().newEditable(mTexto.getEditableText());

        str.clearSpans();
        mTexto.setText(str);
    }

    private void setItalic()
    {
        Editable str = Editable.Factory.getInstance().newEditable(mTexto.getEditableText());

        str.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), mTexto.getSelectionStart(), mTexto.getSelectionEnd(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTexto.setText(str);
    }

    private void setNegrita()
    {
        Editable str = Editable.Factory.getInstance().newEditable(mTexto.getEditableText());

        str.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), mTexto.getSelectionStart(), mTexto.getSelectionEnd(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTexto.setText(str);
    }

    private void cambiarColor()
    {
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        mEtiqueta.setBackgroundColor(color);
    }

    private void recargarImagen()
    {
        mContacto.setImageResource(R.drawable.contact2);
    }
}
