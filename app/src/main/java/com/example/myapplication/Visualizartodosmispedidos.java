package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Visualizartodosmispedidos extends AppCompatActivity {

    Button btnped1, btnped2, btnatras22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizartodosmispedidos);

        btnped1 = findViewById(R.id.btnpedidoscli1);
        btnped2 = findViewById(R.id.btnpedidclie2);
        btnatras22 = findViewById(R.id.btnatrassit);

        btnped1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Visualizarpedidocliente.class));
            }
        });

        btnped2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Verpedidoclienteadomi.class));
            }
        });

        btnatras22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Pantalla_cliente.class));
            }
        });


    }
}