package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.PatternsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Dardealta extends AppCompatActivity {

    EditText altaNom, altaAp,altaCorr,altaCont,altatelf,altarol;
    Button btnAdd, btnback;
    FirebaseAuth fAuth;
    Pattern caract = Pattern.compile(".{9}");
    Pattern caract1 = Pattern.compile(".{7,}");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dardealta);

        altaNom = findViewById(R.id.altaNombre);
        altaAp = findViewById(R.id.altaApellido);
        altaCorr = findViewById(R.id.altaCorreo);
        altaCont = findViewById(R.id.altaContrasenia);
        altatelf = findViewById(R.id.altaTelefono);
        altarol = findViewById(R.id.altaRol);
        fAuth = FirebaseAuth.getInstance();

        btnAdd =findViewById(R.id.btnAgregar);
        btnback = findViewById(R.id.btnatras);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Agregar("http://192.168.68.106/login/dar_de_alta.php");
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

    private void Agregar(String url) {

        final String altaN = altaNom.getText().toString().trim();
        final String altaCor = altaCorr.getText().toString().trim();
        final String altaCon = altaCont.getText().toString().trim();
        final String altaApe = altaAp.getText().toString().trim();
        final String altaTe = altatelf.getText().toString().trim();
        final String altaR = altarol.getText().toString().trim();

        final String correoFA = altaCorr.getText().toString();
        final String contrasFA = altaCont.getText().toString();
        final String altarole =altarol.getText().toString();

        if (altaN.isEmpty() || altaCor.isEmpty() || altaCon.isEmpty() || altaApe.isEmpty() || altaTe.isEmpty() || altaR.isEmpty()) {

            Toast.makeText(Dardealta.this, "Rellene los campos", Toast.LENGTH_SHORT).show();
        } else {
            if (!PatternsCompat.EMAIL_ADDRESS.matcher(altaCor).matches()) {
                Toast.makeText(this, "Email no valido", Toast.LENGTH_SHORT).show();
            } else {
                if (!caract.matcher(altaTe).matches()) {
                    Toast.makeText(this, "Telefono no valido", Toast.LENGTH_SHORT).show();
                } else {

                    if (!caract1.matcher(altaCon).matches()) {
                        Toast.makeText(this, "Contraseña no valida, debe tener al menos longitud 7", Toast.LENGTH_SHORT).show();
                    }else {
                        if (altarole.equals("1") || altarole.equals("2") || altarole.equals("3") || altarole.equals("4") || altarole.equals("5")) {

                        fAuth.createUserWithEmailAndPassword(correoFA, contrasFA).addOnCompleteListener(task -> {

                            if (task.isSuccessful()) {
                                FirebaseUser Muser = fAuth.getCurrentUser();
                                Muser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(Dardealta.this, "Dado de alta", Toast.LENGTH_SHORT).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.d(TAG, "Error: no dado de alta" + e.getMessage());
                                    }
                                });

                            } else {
                                Toast.makeText(Dardealta.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        });

                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response.equalsIgnoreCase("dado de alta")) {
                                    Toast.makeText(getApplicationContext(), "Agregado", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(Dardealta.this, response, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(Dardealta.this, "No se puede agregar", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Dardealta.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> parametros = new HashMap<>();
                                parametros.put("nombre", altaNom.getText().toString());
                                parametros.put("apellidos", altaAp.getText().toString());
                                parametros.put("contrasenia", altaCont.getText().toString());
                                parametros.put("correo", altaCorr.getText().toString());
                                parametros.put("telefono", altatelf.getText().toString());
                                parametros.put("rol", altarol.getText().toString());
                                return parametros;
                            }
                        };
                        RequestQueue requestQueue = Volley.newRequestQueue(this);
                        requestQueue.add(stringRequest);
                    }else{
                            Toast.makeText(this, "Rol no valido", Toast.LENGTH_SHORT).show();
                        }
                }
                }
            }
        }
    }
}