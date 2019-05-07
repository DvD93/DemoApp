package com.unknow.ecorp.esco;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.unknow.ecorp.esco.collections.Peliculas;
import com.unknow.ecorp.esco.entities.Pelicula;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TextView mSeleccion;
    private ListView mPeliculas;

    private PeliculasAdapter mAdpPelis;
    ArrayList<Pelicula> mPelis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        addWidgets();
        //addAdapters();
        addAdapters2();
        addListeners();
    }

    private void addWidgets()
    {
        mSeleccion =  findViewById(R.id.listview_activity_tvSeleccion);
        mPeliculas =  findViewById(R.id.listview_activity_lvPeliculas);
    }

    private void addAdapters()
    {
        ArrayAdapter<CharSequence> adtPelis = ArrayAdapter.createFromResource(this, R.array.peliculas, android.R.layout.simple_list_item_1);

        mPeliculas.setAdapter(adtPelis);
    }

    private void addAdapters2()
    {
        mPelis = Peliculas.getAll(this);
        mAdpPelis = new PeliculasAdapter(this, R.layout.listview_item, mPelis);

        mPeliculas.setAdapter(mAdpPelis);
    }

    private void addListeners()
    {
        mPeliculas.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String opcionSeleccionada = ((Pelicula)parent.getAdapter().getItem(position)).getTitulo();

        //Alternativa 2:
        //String opcionSeleccionada = ((TextView)v.findViewById(R.id.listview_item_tvRanking)).getText().toString();

        mSeleccion.setText(opcionSeleccionada);
    }


    private class PeliculasAdapter extends ArrayAdapter<Pelicula>
    {
        protected ArrayList<Pelicula> items;

        public PeliculasAdapter(Context context, int textViewResourceId, ArrayList<Pelicula> items)
        {
            super(context, textViewResourceId, items);
            this.items = items;
        }

        @Override
        public int getCount()
        {
            return items.size();
        }

        @Override
        public Pelicula getItem(int pos)
        {
            return  items.get(pos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View v = convertView;
            if (v == null)
            {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.listview_item, null);
            }

            Pelicula peli = items.get(position);
            if (peli != null)
            {
                TextView f1 =  v.findViewById(R.id.listview_item_tvRanking);
                TextView f2 =  v.findViewById(R.id.listview_item_tvTitulo);
                TextView f3 =  v.findViewById(R.id.listview_item_tvAnio);

                if (f1 != null)
                    f1.setText(String.valueOf(peli.getRanking()));

                if (f2 != null)
                    f2.setText(peli.getTitulo());

                if (f3 != null)
                    f3.setText("Año " + String.valueOf(peli.getAnio()));
            }
            return v;
        }
    }
}
