package com.unknow.ecorp.esco;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;


import butterknife.ButterKnife;
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private ExpandingList mExpandingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mExpandingList = findViewById(R.id.expanding_list_main);
        createItems();
    }

    private void createItems() {

        addItem("Conceptos Básicos", new String[]{"Layouts","Controles","Vistas","Tab Widgets","Menús","Formulario"}, R.color.purple, R.drawable.icons8_content_filled_50);
        addItem("Conceptos Avanzados", new String[]{"Sql", "Multimedia"}, R.color.yellow, R.drawable.icons8_administrative_tools_64);
        addItem("Demo Apps", new String[]{"Geolocalización","Temperatura","Galería","Autos"}, R.color.orange, R.drawable.icons8_android_tablet_filled_50);
    }
    private void addItem(String title, String[] subItems, int colorRes, int iconRes) {
        //Let's create an item with R.layout.expanding_layout
        final ExpandingItem item = mExpandingList.createNewItem(R.layout.expanding_layout);
        //If item creation is successful, let's configure it
        if (item != null) {
            item.setIndicatorColorRes(colorRes);
            item.setIndicatorIconRes(iconRes);
            //It is possible to get any view inside the inflated layout. Let's set the text in the item
            ((TextView) item.findViewById(R.id.title)).setText(title);

            //We can create items in batch.
            item.createSubItems(subItems.length);
            for (int i = 0; i < item.getSubItemsCount(); i++) {
                //Let's get the created sub item by its index
                final View view = item.getSubItemView(i);

                //Let's set some values in
                configureSubItem(item, view, subItems[i]);
            }
        }
    }

    private void configureSubItem(final ExpandingItem item, final View view, String subTitle) {
        ((TextView) view.findViewById(R.id.sub_title)).setText(subTitle);
    }


    @Override
    public void onResume()
    {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent;

        if (id == R.id.nav_website) {
            try {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://dvd93.github.io"));
                startActivity(intent);
            }catch (ActivityNotFoundException e){
                //nothing here
            }
        }else if (id == R.id.nav_github){
            try {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/DvD93?tab=repositories"));
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                //nothing here
            }
        }else if (id == R.id.nav_linkedin){
            try {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://davidemanuelgonzalezescobar"));
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/profile/view?id=davidemanuelgonzalezescobar"));
                startActivity(intent);
            }
        }else if (id == R.id.nav_instagram){
            try {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_u/dvd.g/"));
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/dvd.g/")));
            }
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void onClick(View v) {
        Intent intent = new Intent();
        //Cargo un TextView con el TextView de v (la vista actual)
        TextView tvSub = (TextView) v;
        //Accedo al texto del TextView que fue hecho "click"
        String option = tvSub.getText().toString();
        //Accedo a la activity que machee con la opcion
        switch (option){
            case "Layouts":
                intent.setClass(MainActivity.this, ResponseActivity.class);
                startActivity(intent);
                break;
            case "Controles":
                intent.setClass(MainActivity.this, ControlesActivity.class);
                startActivity(intent);
                break;
            case "Vistas":
                intent.setClass(MainActivity.this, ViewsActivity.class);
                startActivity(intent);
                break;
            case "Tab Widgets":
                intent.setClass(MainActivity.this, TabsActivity.class);
                startActivity(intent);
                break;
            case "Menús":
                intent.setClass(MainActivity.this, MenusActivity.class);
                startActivity(intent);
                break;
            case "Formulario":
                intent.setClass(MainActivity.this, FormActivity.class);
                startActivity(intent);
                break;
            case "Geolocalización":
                intent.setClass(MainActivity.this, SoapSumarActivity.class);
                startActivity(intent);
                break;
            case "Temperatura":
                intent.setClass(MainActivity.this, SoapTemperaturaActivity.class);
                startActivity(intent);
                break;
            case "Galería":
                intent.setClass(MainActivity.this, SoapPeliculasActivity.class);
                startActivity(intent);
                break;
            case "Multimedia":
                intent.setClass(MainActivity.this, MediaActivity.class);
                startActivity(intent);
                break;
            case "Sql":
                intent.setClass(MainActivity.this, DataBaseActivity.class);
                startActivity(intent);
                break;
            case "Autos":
                intent.setClass(MainActivity.this, Googledb.class);
                startActivity(intent);
                break;
        }

    }

    public void Salir(View view) {
        finish();
        System.exit(0);
    }
}




















