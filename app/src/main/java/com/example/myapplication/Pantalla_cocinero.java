package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Pantalla_cocinero extends AppCompatActivity {

    Button vercomida, verdomi, vermesa, botoncerrCoc;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_cocinero);

        vercomida = findViewById(R.id.comidareservCoci);
        verdomi = findViewById(R.id.btnvercomidaaprepararcam);
        vermesa = findViewById(R.id.btnvercomidaaprepararcam2);

        fAuth = FirebaseAuth.getInstance();

        botoncerrCoc = findViewById(R.id.btnLogoutCoc);

        vercomida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), VerComidaReservada.class));
            }
        });

        verdomi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Visualizarpedidoapreparar.class));
            }
        });

        vermesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Visualizarpedidoaprepararmesa.class));
            }
        });

        botoncerrCoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), iniciarsesion.class));
                finish();
            }
        });
    }
}