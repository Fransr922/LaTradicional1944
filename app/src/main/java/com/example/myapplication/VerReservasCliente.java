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
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class VerReservasCliente extends AppCompatActivity {

    Button cargarclient,cargarclient2;
    ListView listaresultadoclient, listaresultadoclient2;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_reservas_cliente);

        listaresultadoclient = findViewById(R.id.lvListaclient);
        listaresultadoclient2 = findViewById(R.id.lvListaclient2);

        fAuth = FirebaseAuth.getInstance();

        cargarclient = findViewById(R.id.btnLoadclient);
        cargarclient2 =findViewById(R.id.btnLoadclient2);

        cargarclient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String consulta = "http://192.168.68.106/login/verreservascliente.php";
                EnviarRecibirDatosclient();

            }
        });

        cargarclient2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String consulta = "http://192.168.68.106/login/verreservasycomidacliente.php";
                EnviarRecibirDatosclient2();

            }
        });
    }
    public void EnviarRecibirDatosclient(){

        //Toast.makeText(getApplicationContext(), ""+URL, Toast.LENGTH_SHORT).show();
        final String aux2 = fAuth.getCurrentUser().getEmail();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.68.106/login/verreservascliente.php?correo="+aux2+"", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson",""+ja.length());
                        CargarListViewclient(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VerReservasCliente.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }

    public void CargarListViewclient(JSONArray ja){

        ArrayList<String> lista = new ArrayList<>();

        for(int i=0;i<ja.length();i+=3){

            try {

                lista.add(ja.getString(i)+"      "+ja.getString(i+1)+"             "+ja.getString(i+2)+" ");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listaresultadoclient.setAdapter(adaptador);

    }
    ////////////////////////////////////
    public void EnviarRecibirDatosclient2(){

        //Toast.makeText(getApplicationContext(), ""+URL, Toast.LENGTH_SHORT).show();
        final String aux3 = fAuth.getCurrentUser().getEmail();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.68.106/login/verreservasycomidacliente.php?correo="+aux3+"", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson",""+ja.length());
                        CargarListViewclient2(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VerReservasCliente.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }

    public void CargarListViewclient2(JSONArray ja){

        ArrayList<String> lista = new ArrayList<>();

        for(int i=0;i<ja.length();i+=4){

            try {

                lista.add(ja.getString(i)+"   "+ja.getString(i+1)+"          "+ja.getString(i+2)+"\n COMIDA: "+ja.getString(i+3));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listaresultadoclient2.setAdapter(adaptador);

    }

}