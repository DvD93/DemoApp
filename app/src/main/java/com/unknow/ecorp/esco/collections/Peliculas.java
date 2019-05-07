package com.unknow.ecorp.esco.collections;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.unknow.ecorp.esco.PeliculasSQLiteHelper;
import com.unknow.ecorp.esco.R;
import com.unknow.ecorp.esco.entities.Pelicula;


public class Peliculas {

    public static ArrayList<Pelicula> getAll(Context cnt)
    {
        ArrayList<Pelicula> pelis = new ArrayList<Pelicula>();
        List<String> Lines = Arrays
                .asList(cnt.getResources().getStringArray(R.array.peliculas));
        int ranking = 1;

        for(String s : Lines)
        {
            Pelicula peli = new Pelicula();

            peli.setRanking(ranking++);
            peli.setTitulo(s.substring(0, s.indexOf('(')));

            int anio = Integer.parseInt(
                    s.substring(s.indexOf('(') + 1, s.indexOf(')')));
            peli.setAnio(anio);

            pelis.add(peli);
        }

        return pelis;
    }

    public static ArrayList<Pelicula> getAll(Context cntx, boolean verRanking, boolean verAnio)
    {
        ArrayList<Pelicula> pelis = new ArrayList<Pelicula>();

        PeliculasSQLiteHelper pelisHelper = new PeliculasSQLiteHelper(cntx, "DBPeliculas", null, 1);
        SQLiteDatabase db = pelisHelper.getWritableDatabase();
        Cursor c = null;

        if(db != null)
        {
            String[] campos;

            if(verRanking && verAnio)
                campos = new String[] {"ranking", "titulo", "anio"};
            else if(verRanking)
                campos = new String[] {"ranking", "titulo"};
            else if(verAnio)
                campos = new String[] {"titulo", "anio"};
            else
                campos = new String[] {"titulo"};

            try
            {
                c = db.query("Peliculas", campos, null, null, null, null, null);

                if (c.moveToFirst())
                {
                    do
                    {
                        Pelicula peli = new Pelicula();

                        if(verRanking && verAnio)
                        {
                            peli.setRanking(c.getInt(0));
                            peli.setTitulo(c.getString(1));
                            peli.setAnio(c.getInt(2));
                        }
                        else if(verRanking)
                        {
                            peli.setRanking(c.getInt(0));
                            peli.setTitulo(c.getString(1));
                        }
                        else if(verAnio)
                        {
                            peli.setTitulo(c.getString(0));
                            peli.setAnio(c.getInt(1));
                        }
                        else
                            peli.setTitulo(c.getString(0));

                        pelis.add(peli);
                    } while(c.moveToNext());
                }
            }
            catch (Exception e)
            {

            }
            finally
            {
                if(c != null)
                    c.close();

                db.close();
            }

        }

        return pelis;
    }

    public static ArrayList<Pelicula> filter(Context cntx, String ranking, boolean verRanking, boolean verAnio)
    {
        ArrayList<Pelicula> pelis = new ArrayList<Pelicula>();

        PeliculasSQLiteHelper pelisHelper = new PeliculasSQLiteHelper(cntx, "DBPeliculas", null, 1);
        SQLiteDatabase db = pelisHelper.getWritableDatabase();
        Cursor c = null;

        if(db != null)
        {
            String[] campos;

            if(verRanking && verAnio)
                campos = new String[] {"ranking", "titulo", "anio"};
            else if(verRanking)
                campos = new String[] {"ranking", "titulo"};
            else if(verAnio)
                campos = new String[] {"titulo", "anio"};
            else
                campos = new String[] {"titulo"};

            String[] args = new String[] {ranking};

            try
            {
                c = db.query("Peliculas", campos, "ranking=?", args, null, null, null);

                if (c.moveToFirst())
                {
                    do
                    {
                        Pelicula peli = new Pelicula();

                        if(verRanking && verAnio)
                        {
                            peli.setRanking(c.getInt(0));
                            peli.setTitulo(c.getString(1));
                            peli.setAnio(c.getInt(2));
                        }
                        else if(verRanking)
                        {
                            peli.setRanking(c.getInt(0));
                            peli.setTitulo(c.getString(1));
                        }
                        else if(verAnio)
                        {
                            peli.setTitulo(c.getString(0));
                            peli.setAnio(c.getInt(1));
                        }
                        else
                            peli.setTitulo(c.getString(0));

                        pelis.add(peli);
                    } while(c.moveToNext());
                }
            }
            catch (Exception e)
            {

            }
            finally
            {
                if(c != null)
                    c.close();

                db.close();
            }

        }

        return pelis;
    }
}
