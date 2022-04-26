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

public class Visualizarpedidocliente extends AppCompatActivity {

    Button vermisped,iratrs, anulped2;
    EditText anularidames;
    ListView listaverped;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizarpedidocliente);

        vermisped = findViewById(R.id.btnvermisped);
        iratrs = findViewById(R.id.btnirpatr);

        anulped2 = findViewById(R.id.btnnulpediames);
        anularidames = findViewById(R.id.anulidames);

        fAuth = FirebaseAuth.getInstance();

        listaverped = findViewById(R.id.listpedidos);

        vermisped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Vermispedidos();

            }
        });

        anulped2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anularpedadomes();
            }
        });

        iratrs.setOnClickListener(new View.OnClickListener() {
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
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.68.117//login/verpedidocliente.php?correo="+aux2+"", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson",""+ja.length());
                        verpedidmis(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Visualizarpedidocliente.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }

    public void verpedidmis(JSONArray ja){

        ArrayList<String> lista = new ArrayList<>();

        for(int i=0;i<ja.length();i+=4){

            try {

                lista.add("           "+ja.getString(i)+"                     "+ja.getString(i+1)+"                        "+ja.getString(i+2)+"\n COMIDA: "+ja.getString(i+3));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listaverped.setAdapter(adaptador);

    }

    public void anularpedadomes(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.68.117/login/eliminarpedidoamesa.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Pedido a mesa anulado correctame", Toast.LENGTH_SHORT).show();
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
                params.put("id_pedidoMES", anularidames.getText().toString());
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}