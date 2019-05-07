package com.unknow.ecorp.esco.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.util.Xml;

import com.unknow.ecorp.esco.entities.Pelicula;

public class XmlSAXParser {
    private String mXmlBody;
    private Pelicula mPeliculaActual;

    public XmlSAXParser(String xmlBody)
    {
        mXmlBody = xmlBody;
    }

    public List<Pelicula> parse()
    {
        final List<Pelicula> noticias = new ArrayList<Pelicula>();

        RootElement root = new RootElement("Peliculas");
        Element item = root.getChild("Pelicula");

        item.setStartElementListener(new StartElementListener()
        {
            public void start(Attributes attrs)
            {
                mPeliculaActual = new Pelicula();
            }
        });

        item.setEndElementListener(new EndElementListener()
        {
            public void end()
            {
                noticias.add(mPeliculaActual);
            }
        });

        item.getChild("Pelicula").setEndTextElementListener(new EndTextElementListener()
        {
            public void end(String body)
            {
                mPeliculaActual.setTitulo(body);
            }
        });

        item.getChild("Ranking").setEndTextElementListener(new EndTextElementListener()
        {
            public void end(String body)
            {
                mPeliculaActual.setRanking(Integer.parseInt(body));
            }
        });

        item.getChild("Titulo").setEndTextElementListener(new EndTextElementListener()
        {
            public void end(String body)
            {
                mPeliculaActual.setTitulo(body);
            }
        });

        item.getChild("Anio").setEndTextElementListener(new EndTextElementListener()
        {
            public void end(String body)
            {
                mPeliculaActual.setAnio(Integer.parseInt(body));
            }
        });

        try
        {
            Xml.parse(this.getInputStream(), Xml.Encoding.UTF_8, root.getContentHandler());
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }

        return noticias;
    }

    private InputStream getInputStream()
    {
        try
        {
            return new ByteArrayInputStream(mXmlBody.getBytes("UTF-8"));
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

}
