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

public class registrar extends AppCompatActivity {

    EditText txtN,txtA,txtCorr,txtCont,txtTelf;
    Button btn_registrar,btn_iniciar;

    Pattern caract = Pattern.compile(".{9}");
    Pattern caract1 = Pattern.compile(".{7,}");
    FirebaseAuth fAuth;
    int kk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        txtN = findViewById(R.id.nombre);
        txtA = findViewById(R.id.apellidos);
        txtCont= findViewById(R.id.contrasenia);
        txtCorr = findViewById(R.id.correo);
        txtTelf = findViewById(R.id.telefono);

        btn_registrar = findViewById(R.id.btnreg);
        btn_iniciar = findViewById(R.id.btninic);


        btn_registrar.setOnClickListener(v -> insertData());

        btn_iniciar.setOnClickListener(this::login);
        fAuth = FirebaseAuth.getInstance();



    }

    private void insertData() {

        final String nombre = txtN.getText().toString().trim();
        final String apell = txtA.getText().toString().trim();
        final String contras = txtCont.getText().toString().trim();
        final String correo = txtCorr.getText().toString().trim();
        final String correoFIRE = txtCorr.getText().toString();
        final String contrasFIRE = txtCont.getText().toString();
        final String telf = txtTelf.getText().toString().trim();

        if(nombre.isEmpty() || apell.isEmpty() || correo.isEmpty() || contras.isEmpty() || telf.isEmpty()){

            Toast.makeText(registrar.this, "Rellene los campos", Toast.LENGTH_SHORT).show();
        } else {
            if (!PatternsCompat.EMAIL_ADDRESS.matcher(correo).matches()) {
                Toast.makeText(this, "Email no valido", Toast.LENGTH_SHORT).show();
            } else {
                if (!caract.matcher(telf).matches()) {
                    Toast.makeText(this, "Telefono no valido", Toast.LENGTH_SHORT).show();
                }else {
                    if (!caract1.matcher(contras).matches()) {
                        Toast.makeText(this, "Contraseña no valida, debe tener al menos longitud 7", Toast.LENGTH_SHORT).show();
                    }else {


                        fAuth.createUserWithEmailAndPassword(correoFIRE, contrasFIRE).addOnCompleteListener(task -> {

                            if (task.isSuccessful()) {
                                FirebaseUser Tuser = fAuth.getCurrentUser();
                                Tuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(registrar.this, "La verificacion de email ha sido enviada", Toast.LENGTH_SHORT).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.d(TAG, "Error: Email no enviado" + e.getMessage());
                                    }
                                });

                            } else {
                                //Toast.makeText(registrar.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                kk =0;
                            }

                        });

                        if (kk == 0) {
                            Toast.makeText(registrar.this, "El correo ya esta en uso en una cuenta", Toast.LENGTH_SHORT).show();
                        } else{

                            StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.68.106/login/register.php",
                                    new Response.Listener<String>() {

                                        @Override
                                        public void onResponse(String response) {
                                            if (response.equalsIgnoreCase("registro correcto")) {

                                                Toast.makeText(registrar.this, "Registrad@", Toast.LENGTH_SHORT).show();

                                                Intent intent = new Intent(registrar.this, iniciarsesion.class);
                                                startActivity(intent);
                                            } else {
                                                Toast.makeText(registrar.this, response, Toast.LENGTH_SHORT).show();
                                                Toast.makeText(registrar.this, "No se puede registrar", Toast.LENGTH_SHORT).show();
                                            }

                                        }
                                    }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(registrar.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }) {
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {

                                    Map<String, String> params = new HashMap<>();

                                    params.put("nombre", nombre);
                                    params.put("apellidos", apell);
                                    params.put("contrasenia", contras);
                                    params.put("correo", correo);
                                    params.put("telefono", telf);
                                    return params;
                                }
                            };


                        RequestQueue requestQueue = Volley.newRequestQueue(registrar.this);
                        requestQueue.add(request);

                    }
                }//else
                }
            }
        }

    }

    public  void  login(View v){
        startActivity(new Intent(getApplicationContext(), iniciarsesion.class));
        finish();
    }

}