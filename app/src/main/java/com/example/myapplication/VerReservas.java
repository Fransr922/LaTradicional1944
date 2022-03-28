package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class VerReservas extends AppCompatActivity {

    Button cargar,cargar2;
    ListView listaresultado, listaresultado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_reservas);


        listaresultado = findViewById(R.id.lvLista);
        listaresultado2 = findViewById(R.id.lvLista2);

        cargar = findViewById(R.id.btnLoad);
        cargar2 =findViewById(R.id.btnLoad2);

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String consulta = "http://192.168.68.106/login/verreservas.php";
                EnviarRecibirDatos(consulta);

            }
        });

        cargar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String consulta = "http://192.168.68.106/login/verreservasycomida.php";
                EnviarRecibirDatos2(consulta);

            }
        });

    }
    public void EnviarRecibirDatos(String URL){

        //Toast.makeText(getApplicationContext(), ""+URL, Toast.LENGTH_SHORT).show();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson",""+ja.length());
                        CargarListView(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VerReservas.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }

    public void CargarListView(JSONArray ja){

        ArrayList<String> lista = new ArrayList<>();

        for(int i=0;i<ja.length();i+=4){

            try {

                lista.add(ja.getString(i)+"   "+ja.getString(i+1)+"          "+ja.getString(i+2)+"              "+ja.getString(i+3));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listaresultado.setAdapter(adaptador);

    }
    ////////////////////////////////////
    public void EnviarRecibirDatos2(String URL){

        //Toast.makeText(getApplicationContext(), ""+URL, Toast.LENGTH_SHORT).show();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson",""+ja.length());
                        CargarListView2(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VerReservas.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }

    public void CargarListView2(JSONArray ja){

        ArrayList<String> lista = new ArrayList<>();

        for(int i=0;i<ja.length();i+=5){

            try {

                lista.add(ja.getString(i)+"   "+ja.getString(i+1)+"          "+ja.getString(i+2)+"              "+ja.getString(i+3)+"\n COMIDA: "+ja.getString(i+4));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listaresultado2.setAdapter(adaptador);

    }

}