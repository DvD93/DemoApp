package com.unknow.ecorp.esco;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.unknow.ecorp.esco.collections.Albumes;
import com.unknow.ecorp.esco.entities.Album;

import java.util.ArrayList;

public class FotosActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private TextView mAlbum;
    private ViewPager mImagenes;
    private AdapterVerGaleria mAdapter;
    private Button mVolver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotos);

        addWidgets();
        addAdapters();
        addListeners();
    }

    private void addWidgets()
    {
        mAlbum = findViewById(R.id.fotos_activity_tvAlbum);
        mVolver =  findViewById(R.id.fotos_activity_btnVolver);
        mImagenes =  findViewById(R.id.fotos_activity_vpFotos);
    }

    private void addAdapters()
    {
        mAdapter = new AdapterVerGaleria(this);
        mImagenes.setAdapter(mAdapter);
    }

    private void addListeners()
    {
        mVolver.setOnClickListener(this);
        mImagenes.setOnPageChangeListener(this);
    }


    @Override
    public void onClick(View v)
    {
        finish();
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        mAlbum.setText(mAdapter.getDescriptionByID(i));
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    public class AdapterVerGaleria extends PagerAdapter
    {
        private Activity mCtx;
        private ArrayList<Album> mImageIds = Albumes.getAll();

        public AdapterVerGaleria(Activity act)
        {
            mCtx = act;
        }

        public CharSequence getDescriptionByID(int pos)
        {
            return mImageIds.get(pos).getName();
        }

        @Override
        public int getCount()
        {
            return mImageIds.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object)
        {
            return view == ( object);
        }

        @Override
        public Object instantiateItem(View collection, int pos)
        {
            ImageView foto = new ImageView(mCtx);

            foto.setScaleType(ImageView.ScaleType.FIT_XY);

            foto.setBackgroundResource(mImageIds.get(pos).getImageID());

            ((ViewPager) collection).addView(foto);

            return foto;
        }

        @Override
        public void destroyItem(View collection, int position, Object view)
        {
            ((ViewPager) collection).removeView((ImageView) view);

        }
    }
}
