package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
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
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class reservarcomidaymesa extends AppCompatActivity {

    TextView fe,ho, txt;

    //Para la carta
    TextView carT1, carT2,carT3, carT4,carT5, carT6,carT7, carT8,carT9, preC1,preC2, preC3,preC4, preC5, preC6,preC7,preC8,preC9;
    Button comprA1, comprA2, comprA3, comprA4, comprA5, comprA6, comprA7, comprA8, comprA9;


    Button btnreservar, btnaattrraass;

    FirebaseAuth fAuth;

    ListView lista;
    List<String> items;
    ArrayAdapter ADP;

    Spinner Spersons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservarcomidaymesa);

        fe = findViewById(R.id.txtvercalendar);
        ho = findViewById(R.id.txtvertime);

        txt = findViewById(R.id.txttttt);

        btnreservar = findViewById(R.id.btnreservamesaycomida);
        btnaattrraass = findViewById(R.id.btnatrss);

        //Cosas para añadir comida
        ////////////////////////////
        carT1 = findViewById(R.id.carta1234);
        carT2= findViewById(R.id.carta2234);
        carT3= findViewById(R.id.carta3234);
        carT4= findViewById(R.id.carta4234);
        carT5= findViewById(R.id.carta5234);
        carT6= findViewById(R.id.carta6234);
        carT7= findViewById(R.id.carta7234);
        carT8= findViewById(R.id.carta8234);
        carT9= findViewById(R.id.carta9234);

        preC1 = findViewById(R.id.precio1234);
        preC2 = findViewById(R.id.precio2234);
        preC3 = findViewById(R.id.precio3234);
        preC4 = findViewById(R.id.precio4234);
        preC5 = findViewById(R.id.precio5234);
        preC6 = findViewById(R.id.precio6234);
        preC7 = findViewById(R.id.precio7234);
        preC8 = findViewById(R.id.precio8234);
        preC9 = findViewById(R.id.precio9234);

        comprA1 = findViewById(R.id.comp1234);
        comprA2 = findViewById(R.id.comp2234);
        comprA3 = findViewById(R.id.comp3234);
        comprA4 = findViewById(R.id.comp4234);
        comprA5 = findViewById(R.id.comp5234);
        comprA6 = findViewById(R.id.comp6234);
        comprA7 = findViewById(R.id.comp7234);
        comprA8 = findViewById(R.id.comp8234);
        comprA9 = findViewById(R.id.comp9234);
        ////////////////////////

        fAuth = FirebaseAuth.getInstance();


        //listacomida
        lista = findViewById(R.id.listacomidaselect);
        items = new ArrayList<>();
        ADP = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, items);
        lista.setAdapter(ADP);
        lista.setBackgroundColor(Color.DKGRAY);

        //Spiner
        Spersons = findViewById(R.id.spinnerpeople);
        ArrayList<Integer> Personas = new ArrayList<>();
        Personas.add(2);
        Personas.add(4);
        Personas.add(6);
        ArrayAdapter adp = new ArrayAdapter(reservarcomidaymesa.this, android.R.layout.simple_spinner_dropdown_item,Personas);
        Spersons.setAdapter(adp);
        Spersons.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int per = (int) Spersons.getAdapter().getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //Botones para añadir comida
        comprA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(carT1.getText().toString());
                ADP.notifyDataSetChanged();
            }
        });

        comprA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(carT2.getText().toString());
                ADP.notifyDataSetChanged();
            }
        });

        comprA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(carT3.getText().toString());
                ADP.notifyDataSetChanged();
            }
        });

        comprA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(carT4.getText().toString());
                ADP.notifyDataSetChanged();
            }
        });

        comprA5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(carT5.getText().toString());
                ADP.notifyDataSetChanged();
            }
        });

        comprA6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(carT6.getText().toString());
                ADP.notifyDataSetChanged();
            }
        });

        comprA7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(carT7.getText().toString());
                ADP.notifyDataSetChanged();
            }
        });

        comprA8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(carT8.getText().toString());
                ADP.notifyDataSetChanged();
            }
        });

        comprA9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(carT9.getText().toString());
                ADP.notifyDataSetChanged();
            }
        });

        //Reserva
        btnreservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(getApplicationContext(), "Total number of Items are:" + lista.getAdapter().getCount() , Toast.LENGTH_LONG).show();
                for (int i = 0; i < lista.getAdapter().getCount(); i++) {
                    //txt.setText((String)lista.getItemAtPosition(i));

                    //poner coma a comida
                    if (i == 0) {
                        txt.setText(txt.getText() + " " + (String) lista.getItemAtPosition(i));
                    } else {
                        txt.setText(txt.getText() + ", " + (String) lista.getItemAtPosition(i));
                    }


                }

                if (txt.getText().toString().equals("")) {
                    Toast.makeText(reservarcomidaymesa.this, "Selecciona comida", Toast.LENGTH_SHORT).show();
                } else {
                    aniadirreserva("http://192.168.68.117/login/reservarcomida.php?fecha=" + fe.getText() + "" + "&hora=" + ho.getText() + "" + "&personas=" + Spersons.getSelectedItem().toString() + "" + "&comida=" + txt.getText() + "");
                }
            }
        });

        btnaattrraass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Pantalla_cliente.class));
                finish();
            }
        });

    }

    //Cossas para seleccionar fecha y hora
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void abrirCalendar(View view) {

        Calendar cal = Calendar.getInstance();
        int anio = cal.get(Calendar.YEAR);
        int mes =cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(reservarcomidaymesa.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month , int dayofmonth) {
                String fecha = year + "-" + (month +1) + "-" + dayofmonth;
                fe.setText(fecha);
            }
        }, anio, mes, dia);

        dpd.getDatePicker().setMinDate(System.currentTimeMillis());
        dpd.show();
    }

    public void abrirtime(View view) {
        Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        //int min = c.get(Calendar.MINUTE);

        TimePickerDialog tmd = new TimePickerDialog(reservarcomidaymesa.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourofday, int minute) {
                String horario = hourofday + ":0" + 00;
                ho.setText(horario);
            }
        }, hora, 00, true);

        tmd.show();
    }

    public  void aniadirreserva(String url){
        final String aux2 = fAuth.getCurrentUser().getEmail();
        ArrayList<String> xa = new ArrayList<>();
        for (int i = 0; i < lista.getCount(); i++) {
                xa.add((String) lista.getItemAtPosition(i));
        }

        for(int i = 0; i < xa.size(); i++) {
            System.out.println(xa.get(i));
        }

        if (fe.getText().toString().equals("Fecha") || ho.getText().toString().equals("Hora") /*|| txt.getText().toString().equals("")*/){
            Toast.makeText(this, "Campos vacíos", Toast.LENGTH_SHORT).show();
        }else {

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {


                    if (response.equalsIgnoreCase("Reserva realizada")) {
                        Toast.makeText(getApplicationContext(), "Reserva realizada", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Pantalla_cliente.class));
                        finish();

                    } else {

                        if (response.equalsIgnoreCase("Ya hay reservas en ese momento")) {
                            Toast.makeText(reservarcomidaymesa.this, "No hay mesas disponibles para el dia "+fe.getText().toString()+" a la hora "+ho.getText().toString()+".", Toast.LENGTH_SHORT).show();
                        }else{
                            if (response.equalsIgnoreCase("No hay mesas libres para esa hora")) {
                                Toast.makeText(reservarcomidaymesa.this, "No hay mesas disponibles para el dia "+fe.getText().toString()+" a la hora "+ho.getText().toString()+".", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(reservarcomidaymesa.this, "Error: No se puede realizar reserva", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(reservarcomidaymesa.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
}

