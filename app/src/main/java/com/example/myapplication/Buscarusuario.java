package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Buscarusuario extends AppCompatActivity {

    TextView cnombre,bape,bcontra,bcorreo,btelf,brol, comprobar;
    Button btnsearch, btnbaack;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscarusuario);

        cnombre = findViewById(R.id.txtbuscarnombre);
        bape = findViewById(R.id.Bapellidos);
        bcontra = findViewById(R.id.Bcontrasenia);
        bcorreo = findViewById(R.id.Bcorreo);
        btelf = findViewById(R.id.Btelefono);
        brol = findViewById(R.id.Brol);

        comprobar = findViewById(R.id.BUprueb);

        btnsearch = findViewById(R.id.btnbusc);
        btnbaack = findViewById(R.id.buttonatras);

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarUSU("http://192.168.68.117/login/buscarusuario.php?nombre="+cnombre.getText()+"");
            }
        });

        btnbaack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Pantalla_admin.class));
                finish();
            }
        });


    }


    private void buscarUSU (String url){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(JSONArray response) {
                comprobar.setText("ok");
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        bape.setText(jsonObject.getString("apellidos"));
                        bcontra.setText(jsonObject.getString("contrasenia"));
                        bcorreo.setText(jsonObject.getString("correo"));
                        btelf.setText(jsonObject.getString("telefono"));
                        brol.setText(jsonObject.getString("rol"));


                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "No existe usuario", Toast.LENGTH_SHORT).show();
                comprobar.setText("Nok");
            }
        }
        );

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

}