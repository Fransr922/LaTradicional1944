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

public class Editarcuenta extends AppCompatActivity {

    EditText editName, editApe;
    Button btnedit, btnpatras;
    RequestQueue requestQueue;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarcuenta);

        editName = findViewById(R.id.nombreedit);
        editApe = findViewById(R.id.apellidosedit);

        btnedit = findViewById(R.id.btnCambiar);
        btnpatras = findViewById(R.id.btnpatras);

        fAuth = FirebaseAuth.getInstance();

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiar();
            }
        });

        btnpatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Pantalla_cliente.class));
            }
        });
    }

    private void cambiar() {

        if (editName.getText().toString().equals("") && editApe.getText().toString().equals("")) {
            Toast.makeText(this, "Campos vacíos", Toast.LENGTH_SHORT).show();
        }else{


        final String aux2 = fAuth.getCurrentUser().getEmail();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.68.106/login/editarusuario.php?correo=" + aux2 + "", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Cuenta editada", Toast.LENGTH_SHORT).show();
                limpiaar();
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
                Map<String, String> paramss = new HashMap<>();
                paramss.put("nombre", editName.getText().toString());
                paramss.put("apellidos", editApe.getText().toString());

                return paramss;
            }
        };
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        }
    }

    private void limpiaar(){
        editName.setText("");
        editApe.setText("");
    }

}