package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HacerPedidoDomicilio extends AppCompatActivity {

    TextView car1, car2, car3, car4, car5, car6, car7, car8, car9, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8, pre9, aux, textoaux;
    Button compr1, compr2, compr3, compr4, compr5, compr6, compr7, compr8, compr9, btntramit, btnnono;
    Integer suma = 0;

    EditText ubi;
    FirebaseAuth fAuth;

    ListView listacomida;
    List<String> itemscomida;
    ArrayAdapter ADPcomida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hacer_pedido_domicilio);

        car1 = findViewById(R.id.carta1);
        car2 = findViewById(R.id.carta2);
        car3 = findViewById(R.id.carta3);
        car4 = findViewById(R.id.carta4);
        car5 = findViewById(R.id.carta5);
        car6 = findViewById(R.id.carta6);
        car7 = findViewById(R.id.carta7);
        car8 = findViewById(R.id.carta8);
        car9 = findViewById(R.id.carta9);

        pre1 = findViewById(R.id.precio1);
        pre2 = findViewById(R.id.precio2);
        pre3 = findViewById(R.id.precio3);
        pre4 = findViewById(R.id.precio4);
        pre5 = findViewById(R.id.precio5);
        pre6 = findViewById(R.id.precio6);
        pre7 = findViewById(R.id.precio7);
        pre8 = findViewById(R.id.precio8);
        pre9 = findViewById(R.id.precio9);

        compr1 = findViewById(R.id.comp1);
        compr2 = findViewById(R.id.comp2);
        compr3 = findViewById(R.id.comp3);
        compr4 = findViewById(R.id.comp4);
        compr5 = findViewById(R.id.comp5);
        compr6 = findViewById(R.id.comp6);
        compr7 = findViewById(R.id.comp7);
        compr8 = findViewById(R.id.comp8);
        compr9 = findViewById(R.id.comp9);

        ubi = findViewById(R.id.txtubicacion);
        fAuth = FirebaseAuth.getInstance();

        aux = findViewById(R.id.sumaxx);
        textoaux = findViewById(R.id.txtauxed);
        btntramit = findViewById(R.id.btntramitar);

        btnnono = findViewById(R.id.tnnohacer);

        listacomida = findViewById(R.id.listarcomidapedida);
        itemscomida = new ArrayList<>();
        ADPcomida = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, itemscomida);
        listacomida.setAdapter(ADPcomida);
        listacomida.setBackgroundColor(Color.DKGRAY);


        compr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida.add(car1.getText().toString());
                ADPcomida.notifyDataSetChanged();


                String b1 = pre1.getText().toString();
                b1 = b1.substring(0, 2) + b1.substring(3);
                int bb1 = Integer.parseInt(b1);

                suma += bb1;

                String vaya = Integer.toString(suma);
                aux.setText(vaya);
            }
        });

        compr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida.add(car2.getText().toString());
                ADPcomida.notifyDataSetChanged();


                String b2 = pre2.getText().toString();
                b2 = b2.substring(0, 2) + b2.substring(3);
                int bb2 = Integer.parseInt(b2);

                suma += bb2;

                String vaya = Integer.toString(suma);
                aux.setText(vaya);
            }
        });

        compr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida.add(car3.getText().toString());
                ADPcomida.notifyDataSetChanged();


                String b3 = pre3.getText().toString();
                b3 = b3.substring(0, 2) + b3.substring(3);
                int bb3 = Integer.parseInt(b3);

                suma += bb3;

                String vaya = Integer.toString(suma);
                aux.setText(vaya);
            }
        });

        compr4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida.add(car4.getText().toString());
                ADPcomida.notifyDataSetChanged();


                String b4 = pre4.getText().toString();
                b4 = b4.substring(0, 2) + b4.substring(3);
                int bb4 = Integer.parseInt(b4);

                suma += bb4;

                String vaya = Integer.toString(suma);
                aux.setText(vaya);
            }
        });

        compr5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida.add(car5.getText().toString());
                ADPcomida.notifyDataSetChanged();


                String b5 = pre5.getText().toString();
                b5 = b5.substring(0, 2) + b5.substring(3);
                int bb5 = Integer.parseInt(b5);

                suma += bb5;

                String vaya = Integer.toString(suma);
                aux.setText(vaya);
            }
        });

        compr6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida.add(car6.getText().toString());
                ADPcomida.notifyDataSetChanged();


                String b6 = pre6.getText().toString();
                b6 = b6.substring(0, 2) + b6.substring(3);
                int bb6 = Integer.parseInt(b6);

                suma += bb6;

                String vaya = Integer.toString(suma);
                aux.setText(vaya);
            }
        });

        compr7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida.add(car7.getText().toString());
                ADPcomida.notifyDataSetChanged();


                String b7 = pre7.getText().toString();
                b7 = b7.substring(0, 2) + b7.substring(3);
                int bb7 = Integer.parseInt(b7);

                suma += bb7;

                String vaya = Integer.toString(suma);
                aux.setText(vaya);
            }
        });

        compr8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida.add(car8.getText().toString());
                ADPcomida.notifyDataSetChanged();


                String b8 = pre8.getText().toString();
                b8 = b8.substring(0, 2) + b8.substring(3);
                int bb8 = Integer.parseInt(b8);

                suma += bb8;

                String vaya = Integer.toString(suma);
                aux.setText(vaya);
            }
        });

        compr9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida.add(car9.getText().toString());
                ADPcomida.notifyDataSetChanged();


                String b9 = pre9.getText().toString();
                b9 = b9.substring(0, 2) + b9.substring(3);
                int bb9 = Integer.parseInt(b9);

                suma += bb9;

                String vaya = Integer.toString(suma);
                aux.setText(vaya);
            }
        });

        btnnono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Pantalla_cliente.class));
                finish();
            }
        });

        btntramit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Bundle sumaTotal = new Bundle();
                String sumachavos = Integer.toString(suma);
                sumaTotal.putString("sumadinero",sumachavos);*/

                for (int i = 0; i < listacomida.getAdapter().getCount(); i++) {
                    //txt.setText((String)lista.getItemAtPosition(i));

                    //poner coma a comida
                    if(i==0){
                        textoaux.setText(textoaux.getText() + " " + (String) listacomida.getItemAtPosition(i));
                    }else{
                        textoaux.setText(textoaux.getText() + ", " + (String) listacomida.getItemAtPosition(i));
                    }

                }

                if (ubi.getText().toString().equals("")) {
                    Toast.makeText(HacerPedidoDomicilio.this, "Rellene ubicación", Toast.LENGTH_SHORT).show();
                } else {
                    if (textoaux.getText().toString().equals("")) {
                        Toast.makeText(HacerPedidoDomicilio.this, "Pida comida", Toast.LENGTH_SHORT).show();
                    } else {
                        aniadirenbbdd("http://192.168.68.117/login/pedidosadomicilio.php?direccion=" + ubi.getText().toString() + "" + "&comida=" + textoaux.getText() + "&coste=" + aux.getText() + "");

                    }

                }

            }
        });

    }

    public void aniadirenbbdd(String url) {
        final String aux2 = fAuth.getCurrentUser().getEmail();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equalsIgnoreCase("Pedido a domicilio realizado")) {
                    Toast.makeText(getApplicationContext(), "Pedido a domicilio realizado", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), Pantalla_cliente.class));
                    finish();

                } else {
                    Toast.makeText(HacerPedidoDomicilio.this, "No se ha podido realizar pedido", Toast.LENGTH_SHORT).show();
                    textoaux.setText("");
                    ubi.setText("");
                    aux.setText("");
                    ADPcomida.clear();
                    suma = 0;
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HacerPedidoDomicilio.this, "No se ha podido realizar pedido", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> paramtros = new HashMap<>();
                paramtros.put("correo", aux2);
                return paramtros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


}



