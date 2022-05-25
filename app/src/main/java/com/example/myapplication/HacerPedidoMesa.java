package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
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

public class HacerPedidoMesa extends AppCompatActivity {

    TextView car12, car22, car32, car42, car52, car62, car72, car82, car92, pre12, pre22, pre32, pre42, pre52, pre62, pre72, pre82, pre92, aux2, textoaux2;
    Button compr12, compr22, compr32, compr42, compr52, compr62, compr72, compr82, compr92, btntramit2, btnnono2;
    Integer suma2 = 0;


    FirebaseAuth fAuth2;


    Spinner Smesas;

    ListView listacomida2;
    List<String> itemscomida2;
    ArrayAdapter ADPcomida2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hacer_pedido_mesa);

        car12 = findViewById(R.id.carta12);
        car22 = findViewById(R.id.carta22);
        car32 = findViewById(R.id.carta32);
        car42 = findViewById(R.id.carta42);
        car52 = findViewById(R.id.carta52);
        car62 = findViewById(R.id.carta62);
        car72 = findViewById(R.id.carta72);
        car82 = findViewById(R.id.carta82);
        car92 = findViewById(R.id.carta92);

        pre12 = findViewById(R.id.precio12);
        pre22 = findViewById(R.id.precio22);
        pre32 = findViewById(R.id.precio32);
        pre42 = findViewById(R.id.precio42);
        pre52 = findViewById(R.id.precio52);
        pre62 = findViewById(R.id.precio62);
        pre72 = findViewById(R.id.precio72);
        pre82 = findViewById(R.id.precio82);
        pre92 = findViewById(R.id.precio92);

        compr12 = findViewById(R.id.comp12);
        compr22 = findViewById(R.id.comp22);
        compr32 = findViewById(R.id.comp32);
        compr42 = findViewById(R.id.comp42);
        compr52 = findViewById(R.id.comp52);
        compr62 = findViewById(R.id.comp62);
        compr72 = findViewById(R.id.comp72);
        compr82 = findViewById(R.id.comp82);
        compr92 = findViewById(R.id.comp92);


        fAuth2 = FirebaseAuth.getInstance();

        aux2 = findViewById(R.id.sumaxx2);
        textoaux2 = findViewById(R.id.txtauxed2);
        btntramit2 = findViewById(R.id.btnpediramesa);

        btnnono2 = findViewById(R.id.tnnohacer2);

        Smesas = findViewById(R.id.spinnermesita);

        ArrayList<Integer> Mesas = new ArrayList<>();

        Mesas.add(1);
        Mesas.add(2);
        Mesas.add(3);
        Mesas.add(4);
        Mesas.add(5);
        Mesas.add(6);

        ArrayAdapter adp = new ArrayAdapter(HacerPedidoMesa.this, android.R.layout.simple_spinner_dropdown_item, Mesas);

        Smesas.setAdapter(adp);

        Smesas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int per = (int) Smesas.getAdapter().getItem(i);
                //Toast.makeText(Reservarmesa.this, "Seleccionaste: " + per,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listacomida2 = findViewById(R.id.listarcomidapedida2);
        itemscomida2 = new ArrayList<>();
        ADPcomida2 = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, itemscomida2);
        listacomida2.setAdapter(ADPcomida2);
        listacomida2.setBackgroundColor(Color.DKGRAY);


        compr12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida2.add(car12.getText().toString());
                ADPcomida2.notifyDataSetChanged();


                String b1 = pre12.getText().toString();
                b1 = b1.substring(0, 2) + b1.substring(3);
                int bb1 = Integer.parseInt(b1);

                suma2 += bb1;

                String vaya = Integer.toString(suma2);
                aux2.setText(vaya);
            }
        });

        compr22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida2.add(car22.getText().toString());
                ADPcomida2.notifyDataSetChanged();


                String b2 = pre22.getText().toString();
                b2 = b2.substring(0, 2) + b2.substring(3);
                int bb2 = Integer.parseInt(b2);

                suma2 += bb2;

                String vaya = Integer.toString(suma2);
                aux2.setText(vaya);
            }
        });

        compr32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida2.add(car32.getText().toString());
                ADPcomida2.notifyDataSetChanged();


                String b3 = pre32.getText().toString();
                b3 = b3.substring(0, 2) + b3.substring(3);
                int bb3 = Integer.parseInt(b3);

                suma2 += bb3;

                String vaya = Integer.toString(suma2);
                aux2.setText(vaya);
            }
        });

        compr42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida2.add(car42.getText().toString());
                ADPcomida2.notifyDataSetChanged();


                String b4 = pre42.getText().toString();
                b4 = b4.substring(0, 2) + b4.substring(3);
                int bb4 = Integer.parseInt(b4);

                suma2 += bb4;

                String vaya = Integer.toString(suma2);
                aux2.setText(vaya);
            }
        });

        compr52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida2.add(car52.getText().toString());
                ADPcomida2.notifyDataSetChanged();


                String b5 = pre52.getText().toString();
                b5 = b5.substring(0, 2) + b5.substring(3);
                int bb5 = Integer.parseInt(b5);

                suma2 += bb5;

                String vaya = Integer.toString(suma2);
                aux2.setText(vaya);
            }
        });

        compr62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida2.add(car62.getText().toString());
                ADPcomida2.notifyDataSetChanged();


                String b6 = pre62.getText().toString();
                b6 = b6.substring(0, 2) + b6.substring(3);
                int bb6 = Integer.parseInt(b6);

                suma2 += bb6;

                String vaya = Integer.toString(suma2);
                aux2.setText(vaya);
            }
        });

        compr72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida2.add(car72.getText().toString());
                ADPcomida2.notifyDataSetChanged();


                String b7 = pre72.getText().toString();
                b7 = b7.substring(0, 2) + b7.substring(3);
                int bb7 = Integer.parseInt(b7);

                suma2 += bb7;

                String vaya = Integer.toString(suma2);
                aux2.setText(vaya);
            }
        });

        compr82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida2.add(car82.getText().toString());
                ADPcomida2.notifyDataSetChanged();


                String b8 = pre82.getText().toString();
                b8 = b8.substring(0, 2) + b8.substring(3);
                int bb8 = Integer.parseInt(b8);

                suma2 += bb8;

                String vaya = Integer.toString(suma2);
                aux2.setText(vaya);
            }
        });

        compr92.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida2.add(car92.getText().toString());
                ADPcomida2.notifyDataSetChanged();


                String b9 = pre92.getText().toString();
                b9 = b9.substring(0, 2) + b9.substring(3);
                int bb9 = Integer.parseInt(b9);

                suma2 += bb9;

                String vaya = Integer.toString(suma2);
                aux2.setText(vaya);
            }
        });

        btnnono2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Pantalla_cliente.class));
                finish();
            }
        });

        btntramit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Bundle sumaTotal = new Bundle();
                String sumachavos = Integer.toString(suma);
                sumaTotal.putString("sumadinero",sumachavos);*/

                for (int i = 0; i < listacomida2.getAdapter().getCount(); i++) {
                    //txt.setText((String)lista.getItemAtPosition(i));

                    //poner coma a comida
                    if(i==0){
                        textoaux2.setText(textoaux2.getText() + " " + (String) listacomida2.getItemAtPosition(i));
                    }else{
                        textoaux2.setText(textoaux2.getText() + ", " + (String) listacomida2.getItemAtPosition(i));
                    }

                }

                if (textoaux2.getText().toString().equals("")) {
                    Toast.makeText(HacerPedidoMesa.this, "Pida comida", Toast.LENGTH_SHORT).show();
                } else {
                    String kk = aux2.getText().toString();
                    int kk2 = Integer.parseInt(kk);
                    aniadirenbbdd("http://192.168.68.117/login/pedidomesa.php?mesa=" + Smesas.getSelectedItem().toString() + "" + "&comida=" + textoaux2.getText() + "" + "&gasto=" + kk2 + "");
                    textoaux2.setText("");
                    aux2.setText("");
                    ADPcomida2.clear();
                    suma2 = 0;
                }


            }
        });

    }

    public void aniadirenbbdd(String url) {
        final String aux99 = fAuth2.getCurrentUser().getEmail();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equalsIgnoreCase("Pedido a mesa realizado")) {
                    Toast.makeText(getApplicationContext(), "Pedido a mesa realizado", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), Pantalla_cliente.class));
                    finish();

                } else {
                    //Toast.makeText(HacerPedidoMesa.this, response, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "No se ha podido realizar el pedido", Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "No se ha podido realizar el pedido", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> paramtros = new HashMap<>();
                paramtros.put("correo", aux99);
                return paramtros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}