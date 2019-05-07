package com.unknow.ecorp.esco;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestTemperaturaActivity extends AppCompatActivity {

    TextView sal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_temperatura);

         sal = findViewById(R.id.tvSalida);
        GetData();
    }
    public void GetData(){
        String sql = "http://skiboo.com.mx/api/business/rewards/49";
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        URL url = null;
        HttpURLConnection conn;

        try {
            url = new URL(sql);

            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;

            StringBuffer response = new StringBuffer();

            String json = "";

            while ((inputLine = in.readLine()) != null){
                response.append(inputLine);

            }

            json = response.toString();

            JSONArray jsonArray = null;

            jsonArray = new JSONArray(json);

            String mensaje = "";

            for (int i = 0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Log.d("SALIDA", jsonObject.optString("descripcion"));

                mensaje += "DESCRIPCION" +i+" " +jsonObject.optString("descripcion")+"\n";
            }

            sal.setText(mensaje);

        } catch (MalformedURLException e) {
                e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
