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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class Tomarnota extends AppCompatActivity {

    TextView car123, car223, car323, car423, car523, car623, car723, car823, car923, pre123, pre223, pre323, pre423, pre523, pre623, pre723, pre823, pre923, aux23, textoaux23;
    Button compr123, compr223, compr323, compr423, compr523, compr623, compr723, compr823, compr923, btntramit23, btnnono23;
    Integer suma23 = 0;

    Spinner Smesas3;

    ListView listacomida23;
    List<String> itemscomida23;
    ArrayAdapter ADPcomida23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomarnota);

        car123 = findViewById(R.id.carta123);
        car223= findViewById(R.id.carta223);
        car323= findViewById(R.id.carta323);
        car423= findViewById(R.id.carta423);
        car523= findViewById(R.id.carta523);
        car623= findViewById(R.id.carta623);
        car723= findViewById(R.id.carta723);
        car823= findViewById(R.id.carta823);
        car923= findViewById(R.id.carta923);

        pre123 = findViewById(R.id.precio123);
        pre223 = findViewById(R.id.precio223);
        pre323= findViewById(R.id.precio323);
        pre423= findViewById(R.id.precio423);
        pre523= findViewById(R.id.precio523);
        pre623= findViewById(R.id.precio623);
        pre723= findViewById(R.id.precio723);
        pre823= findViewById(R.id.precio823);
        pre923= findViewById(R.id.precio923);

        compr123 = findViewById(R.id.comp123);
        compr223 = findViewById(R.id.comp223);
        compr323 = findViewById(R.id.comp323);
        compr423 = findViewById(R.id.comp423);
        compr523 = findViewById(R.id.comp523);
        compr623 = findViewById(R.id.comp623);
        compr723 = findViewById(R.id.comp723);
        compr823 = findViewById(R.id.comp823);
        compr923 = findViewById(R.id.comp923);

        aux23 = findViewById(R.id.sumaxx23);
        textoaux23 = findViewById(R.id.txtauxed23);
        btntramit23 = findViewById(R.id.btnpediramesa3);

        btnnono23 = findViewById(R.id.tnnohacer23);

        Smesas3 = findViewById(R.id.spinnermesita3);

        ArrayList<Integer> Mesas3 = new ArrayList<>();

        Mesas3.add(1);
        Mesas3.add(2);
        Mesas3.add(3);
        Mesas3.add(4);
        Mesas3.add(5);
        Mesas3.add(6);

        ArrayAdapter adp = new ArrayAdapter(Tomarnota.this, android.R.layout.simple_spinner_dropdown_item, Mesas3);

        Smesas3.setAdapter(adp);

        Smesas3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int per = (int) Smesas3.getAdapter().getItem(i);
                //Toast.makeText(Reservarmesa.this, "Seleccionaste: " + per,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listacomida23 = findViewById(R.id.listarcomidapedida23);
        itemscomida23 = new ArrayList<>();
        ADPcomida23 = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, itemscomida23);
        listacomida23.setAdapter(ADPcomida23);
        listacomida23.setBackgroundColor(Color.DKGRAY);


        compr123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida23.add(car123.getText().toString());
                ADPcomida23.notifyDataSetChanged();


                String b1 = pre123.getText().toString();
                b1 = b1.substring(0, 2) + b1.substring(3);
                int bb1 = Integer.parseInt(b1);

                suma23 += bb1;

                String vaya = Integer.toString(suma23);
                aux23.setText(vaya);
            }
        });

        compr223.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida23.add(car223.getText().toString());
                ADPcomida23.notifyDataSetChanged();


                String b2 = pre223.getText().toString();
                b2 = b2.substring(0, 2) + b2.substring(3);
                int bb2 = Integer.parseInt(b2);

                suma23 += bb2;

                String vaya = Integer.toString(suma23);
                aux23.setText(vaya);
            }
        });

        compr323.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida23.add(car323.getText().toString());
                ADPcomida23.notifyDataSetChanged();


                String b3 = pre323.getText().toString();
                b3 = b3.substring(0, 2) + b3.substring(3);
                int bb3 = Integer.parseInt(b3);

                suma23 += bb3;

                String vaya = Integer.toString(suma23);
                aux23.setText(vaya);
            }
        });

        compr423.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida23.add(car423.getText().toString());
                ADPcomida23.notifyDataSetChanged();


                String b4 = pre423.getText().toString();
                b4 = b4.substring(0, 2) + b4.substring(3);
                int bb4 = Integer.parseInt(b4);

                suma23 += bb4;

                String vaya = Integer.toString(suma23);
                aux23.setText(vaya);
            }
        });

        compr523.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida23.add(car523.getText().toString());
                ADPcomida23.notifyDataSetChanged();


                String b5 = pre523.getText().toString();
                b5 = b5.substring(0, 2) + b5.substring(3);
                int bb5 = Integer.parseInt(b5);

                suma23 += bb5;

                String vaya = Integer.toString(suma23);
                aux23.setText(vaya);
            }
        });

        compr623.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida23.add(car623.getText().toString());
                ADPcomida23.notifyDataSetChanged();


                String b6 = pre623.getText().toString();
                b6 = b6.substring(0, 2) + b6.substring(3);
                int bb6 = Integer.parseInt(b6);

                suma23 += bb6;

                String vaya = Integer.toString(suma23);
                aux23.setText(vaya);
            }
        });

        compr723.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida23.add(car723.getText().toString());
                ADPcomida23.notifyDataSetChanged();


                String b7 = pre723.getText().toString();
                b7 = b7.substring(0, 2) + b7.substring(3);
                int bb7 = Integer.parseInt(b7);

                suma23 += bb7;

                String vaya = Integer.toString(suma23);
                aux23.setText(vaya);
            }
        });

        compr823.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida23.add(car823.getText().toString());
                ADPcomida23.notifyDataSetChanged();


                String b8 = pre823.getText().toString();
                b8 = b8.substring(0, 2) + b8.substring(3);
                int bb8 = Integer.parseInt(b8);

                suma23 += bb8;

                String vaya = Integer.toString(suma23);
                aux23.setText(vaya);
            }
        });

        compr923.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemscomida23.add(car923.getText().toString());
                ADPcomida23.notifyDataSetChanged();


                String b9 = pre923.getText().toString();
                b9 = b9.substring(0, 2) + b9.substring(3);
                int bb9 = Integer.parseInt(b9);

                suma23 += bb9;

                String vaya = Integer.toString(suma23);
                aux23.setText(vaya);
            }
        });

        btnnono23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Pantalla_camarero.class));
                finish();
            }
        });

        btntramit23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Bundle sumaTotal = new Bundle();
                String sumachavos = Integer.toString(suma);
                sumaTotal.putString("sumadinero",sumachavos);*/

                for (int i = 0; i < listacomida23.getAdapter().getCount(); i++) {
                    //txt.setText((String)lista.getItemAtPosition(i));

                    //poner coma a comida
                    if(i==0){
                        textoaux23.setText(textoaux23.getText() + " " + (String) listacomida23.getItemAtPosition(i));
                    }else{
                        textoaux23.setText(textoaux23.getText() + ", " + (String) listacomida23.getItemAtPosition(i));
                    }


                }

                if (textoaux23.getText().toString().equals("")) {
                    Toast.makeText(Tomarnota.this, "Selecciona comida", Toast.LENGTH_SHORT).show();
                } else {
                    String kk = aux23.getText().toString();
                    int kk2 = Integer.parseInt(kk);
                    aniadirenbbdd3("http://192.168.68.117/login/tomarnota.php?mesa=" + Smesas3.getSelectedItem().toString() + "" + "&comida=" + textoaux23.getText() + "" + "&gasto=" + kk2 + "");

                }


            }
        });

    }


    public void aniadirenbbdd3(String url) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equalsIgnoreCase("Anotado")) {
                    Toast.makeText(getApplicationContext(), "Se ha tomado nota correctamente", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), Pantalla_camarero.class));
                    finish();


                } else {
                    Toast.makeText(Tomarnota.this, response, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "No se ha podido tomar nota", Toast.LENGTH_SHORT).show();
                    textoaux23.setText("");
                    aux23.setText("");
                    ADPcomida23.clear();
                    suma23 = 0;
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Tomarnota.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}