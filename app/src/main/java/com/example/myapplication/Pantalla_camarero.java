package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Pantalla_camarero extends AppCompatActivity {

    Button btnverreservaC,btnnota,btnverpedidos, btncerrarC;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_camarero);

        btnverreservaC = findViewById(R.id.verreservasC);
        btnnota = findViewById(R.id.btntomarnota);
        btnverpedidos = findViewById(R.id.btnverpeds);
        btncerrarC = findViewById(R.id.btnLogoutCam);


        fAuth = FirebaseAuth.getInstance();

        btnverreservaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), VerReservas.class));
            }
        });

        btnnota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Tomarnota.class));
            }
        });

        btnverpedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Visualizarpedidos.class));
            }
        });

        btncerrarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), iniciarsesion.class));
                finish();
            }
        });


    }
}