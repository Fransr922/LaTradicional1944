package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
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
import java.util.HashMap;
import java.util.Map;

public class Verpedidoclienteadomi extends AppCompatActivity {

    Button vermispedad,iratrsad, anulped;
    EditText anularidadomi;
    ListView listaverpedad;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verpedidoclienteadomi);

        vermispedad = findViewById(R.id.btnvermispedadomi);
        iratrsad = findViewById(R.id.btnirpatradomi);
        anulped = findViewById(R.id.btnnulpediadomi);
        anularidadomi = findViewById(R.id.anulidadom);

        fAuth = FirebaseAuth.getInstance();

        listaverpedad = findViewById(R.id.listpedidosadomi);

        vermispedad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Vermispedidos();

            }
        });

        anulped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anularpedadomi();
            }
        });

        iratrsad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Visualizartodosmispedidos.class));
            }
        });

    }

    public void Vermispedidos(){

        //Toast.makeText(getApplicationContext(), ""+URL, Toast.LENGTH_SHORT).show();
        final String aux2 = fAuth.getCurrentUser().getEmail();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.68.117/login/verpedidoclienteadomi.php?correo="+aux2+"", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson",""+ja.length());
                        verpedidmisad(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Verpedidoclienteadomi.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }

    public void verpedidmisad(JSONArray ja){

        ArrayList<String> lista = new ArrayList<>();

        for(int i=0;i<ja.length();i+=3){

            try {

                lista.add("                         "+ja.getString(i)+"                         "+ja.getString(i+1)+"\n COMIDA: "+ja.getString(i+2));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listaverpedad.setAdapter(adaptador);

    }

    public void anularpedadomi(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.68.117/login/eliminarpedidoadomi.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Pedido a domicilio anulado correctame", Toast.LENGTH_SHORT).show();
                //limpiar();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("id_pedidoDOM", anularidadomi.getText().toString());
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}