package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

public class DarsedeBaja extends AppCompatActivity {

    EditText correoconf;
    Button btnacept,btnatrs;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darsede_baja);

        correoconf = findViewById(R.id.correoconf);
        btnacept = findViewById(R.id.btnaceptar);
        btnatrs = findViewById(R.id.btnatr);

        fAuth = FirebaseAuth.getInstance();

        btnacept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baja("http://192.168.68.106/login/dardebaja.php");
            }
        });

        btnatrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Pantalla_cliente.class));
            }
        });

    }
    public void baja(String url) {

        final String correoC = correoconf.getText().toString().trim();
        if (correoC.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Rellene el correo", Toast.LENGTH_SHORT).show();
        } else{

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(), "Usuario eliminado correctame", Toast.LENGTH_SHORT).show();
                    fAuth.getCurrentUser().delete();
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(getApplicationContext(), iniciarsesion.class));
                    finish();
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
                    params.put("correo", correoconf.getText().toString());
                    return params;
                }
            };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        }
    }
}