package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;
import java.util.Map;

public class Pantalla_cliente extends AppCompatActivity {

    TextView NoVerificado;
    Button btnVerificar, btncerrar, btnbaja, btnedit;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_cliente);

        btnVerificar = findViewById(R.id.btnVerificar);
        btncerrar = findViewById(R.id.btnLogout);
        btnbaja = findViewById(R.id.btnBaja);
        btnedit = findViewById(R.id.btneditarcuenta);

        NoVerificado = findViewById(R.id.txtNoverificado);
        fAuth = FirebaseAuth.getInstance();

        final FirebaseUser fusu = fAuth.getCurrentUser();

        if (!fusu.isEmailVerified()) {

            NoVerificado.setVisibility(View.VISIBLE);
            btnVerificar.setVisibility(View.VISIBLE);
            btnVerificar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fusu.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(view.getContext(), "La verificacion de email ha sido enviada", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, "Error: Email no enviado" + e.getMessage());
                        }
                    });
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(getApplicationContext(), iniciarsesion.class));
                    finish();
                }
            });
        }

    btncerrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), iniciarsesion.class));
            finish();
        }
    });

        btnbaja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DarsedeBaja.class));
            }
        });

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Editarcuenta.class));
            }
        });



    }


}