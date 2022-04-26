package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.PatternsCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

public class iniciarsesion extends AppCompatActivity {
    EditText email, contrasenia;



    String str_email,str_password;
    String url = "http://192.168.68.117/login/iniciarsesion.php";

    Button btnInic, btnReg;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarsesion);

        email = findViewById(R.id.txtCorreo);
        contrasenia = findViewById(R.id.txtcontrasenia);

        btnInic = findViewById(R.id.boton_iniciar_sesion);
        btnReg = findViewById(R.id.boton_registrar);

        fAuth = FirebaseAuth.getInstance();


        btnInic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login(view);
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToRegistration(view);
            }
        });



    }

    public void Login(View view) {

        if(email.getText().toString().equals("") || contrasenia.getText().toString().equals("")){
            Toast.makeText(this, "Rellenar campos", Toast.LENGTH_SHORT).show();

        }
        else {
            if (!PatternsCompat.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                Toast.makeText(this, "Email no valido", Toast.LENGTH_SHORT).show();
            } else {
                str_email = email.getText().toString().trim();
                str_password = contrasenia.getText().toString().trim();



                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.equalsIgnoreCase("cliente")) {

                            fAuth.signInWithEmailAndPassword(str_email,str_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        startActivity(new Intent(getApplicationContext(), Pantalla_cliente.class));
                                    }

                                }
                            });

                        } else {
                            if (response.equalsIgnoreCase("administrador")) {
                                fAuth.signInWithEmailAndPassword(str_email,str_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful()){
                                            startActivity(new Intent(getApplicationContext(), Pantalla_admin.class));
                                        }

                                    }
                                });

                            } else {
                                if (response.equalsIgnoreCase("camarero")) {
                                    fAuth.signInWithEmailAndPassword(str_email,str_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if(task.isSuccessful()){
                                                startActivity(new Intent(getApplicationContext(), Pantalla_camarero.class));
                                            }

                                        }
                                    });
                                } else {
                                    if (response.equalsIgnoreCase("cocinero")) {
                                        fAuth.signInWithEmailAndPassword(str_email,str_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                if(task.isSuccessful()){
                                                    startActivity(new Intent(getApplicationContext(), Pantalla_cocinero.class));
                                                }

                                            }
                                        });
                                    } else {
                                        if (response.equalsIgnoreCase("trasportista")) {
                                            fAuth.signInWithEmailAndPassword(str_email,str_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {
                                                    if(task.isSuccessful()){
                                                        startActivity(new Intent(getApplicationContext(), Pantalla_trasportista.class));
                                                    }

                                                }
                                            });
                                        } else {
                                            Toast.makeText(iniciarsesion.this, response, Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(iniciarsesion.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
                ) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("correo", str_email);
                        params.put("contrasenia", str_password);
                        return params;

                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(iniciarsesion.this);
                requestQueue.add(request);


            }
        }
    }

    public void moveToRegistration(View view) {
        startActivity(new Intent(getApplicationContext(), registrar.class));
        finish();
    }
}