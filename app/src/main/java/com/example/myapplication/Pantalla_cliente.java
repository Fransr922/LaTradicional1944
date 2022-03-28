package com.example.myapplication;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Pantalla_cliente extends AppCompatActivity {

    TextView NoVerificado;
    Button btnVerificar, btncerrar, btnbaja, btnedit, btnreserva, btnreservacomida, btnprueba, btnverreservasclient, btnanulreserv;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_cliente);

        btnVerificar = findViewById(R.id.btnVerificar);
        btncerrar = findViewById(R.id.btnLogout);
        btnbaja = findViewById(R.id.btnBaja);
        btnedit = findViewById(R.id.btneditarcuenta);
        btnreserva = findViewById(R.id.btnreservar);
        btnreservacomida = findViewById(R.id.btnreservarmyc);
        btnverreservasclient = findViewById(R.id.btnverreservascliente);
        btnanulreserv = findViewById(R.id.btnanularservaXD);

        btnprueba = findViewById(R.id.btnprueb);

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

        btnreserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Reservarmesa.class));
            }
        });

        btnreservacomida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), reservarcomidaymesa.class));
            }
        });

        btnverreservasclient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), VerReservasCliente.class));
            }
        });

        btnanulreserv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AnularReserva.class));
            }
        });


    }


}