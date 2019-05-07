package com.unknow.ecorp.esco.collections;

import com.unknow.ecorp.esco.R;
import com.unknow.ecorp.esco.entities.Album;

import java.util.ArrayList;

public class Albumes {

    public static ArrayList<Album> getAll()
    {
        ArrayList<Album> items = new ArrayList<Album>();

        Album album = new Album();
        album.setImageID(R.drawable.mtv_unplugged);
        album.setName("Mtv Unplugged");
        items.add(album);

        album = new Album();
        album.setImageID(R.drawable.pearl_jam);
        album.setName("Pearl Jam");
        items.add(album);

        album = new Album();
        album.setImageID(R.drawable.ten);
        album.setName("Ten");
        items.add(album);

        album = new Album();
        album.setImageID(R.drawable.vitalogy);
        album.setName("Vitalogy");
        items.add(album);

        album = new Album();
        album.setImageID(R.drawable.vs);
        album.setName("VS");
        items.add(album);

        album = new Album();
        album.setImageID(R.drawable.yield);
        album.setName("Yield");
        items.add(album);

        album = new Album();
        album.setImageID(R.drawable.riot_act);
        album.setName("Riot Act");
        items.add(album);

        album = new Album();
        album.setImageID(R.drawable.no_code);
        album.setName("No Code");
        items.add(album);

        return items;
    }
}
