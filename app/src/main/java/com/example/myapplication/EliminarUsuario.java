package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.Map;

public class EliminarUsuario extends AppCompatActivity {

    EditText nombreelim,correoelim;
    Button btndelete,btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_usuario);

        nombreelim = findViewById(R.id.txtNombreElim);
        correoelim = findViewById(R.id.txtCorreoElim);
        btndelete = findViewById(R.id.btnEliminar);
        btnback = findViewById(R.id.botonatras);

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminar("http://192.168.68.106/login/eliminarusuario.php");
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Pantalla_admin.class));
                finish();
            }
        });
    }

    private void eliminar(String url){

        final String correoE = correoelim.getText().toString().trim();
        final String nombreE = nombreelim.getText().toString().trim();

        if (correoE.isEmpty() || nombreE.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Rellene campos", Toast.LENGTH_SHORT).show();
        } else {

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(), "Usuario eliminado correctame", Toast.LENGTH_SHORT).show();
                    limpiar();
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
                    params.put("nombre", nombreelim.getText().toString());
                    params.put("correo", correoelim.getText().toString());
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

    }

    private void limpiar(){
        nombreelim.setText("");
        correoelim.setText("");
    }

}