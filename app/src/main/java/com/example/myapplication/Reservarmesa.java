package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Reservarmesa extends AppCompatActivity {

    TextView tv, hr;
    Button btnreservar,btnba;
    FirebaseAuth fAuth;
    Spinner Spersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservarmesa);

        tv =findViewById(R.id.textoFecha);
        hr = findViewById(R.id.textoHora);

        btnreservar = findViewById(R.id.btnhacerreserva);
        btnba = findViewById(R.id.btncanc);

        fAuth = FirebaseAuth.getInstance();

        Spersonas = findViewById(R.id.spinnerpersonas);

        ArrayList<Integer> Personas = new ArrayList<>();

        Personas.add(2);
        Personas.add(4);
        Personas.add(6);

        ArrayAdapter adp = new ArrayAdapter(Reservarmesa.this, android.R.layout.simple_spinner_dropdown_item,Personas);

        Spersonas.setAdapter(adp);

        Spersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int per = (int) Spersonas.getAdapter().getItem(i);
                //Toast.makeText(Reservarmesa.this, "Seleccionaste: " + per,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnreservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Texto spinner:"+ Spersonas.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                incluirreserva("http://192.168.68.106/login/reservar.php?fecha="+tv.getText()+""+"&hora="+hr.getText()+""+"&personas="+Spersonas.getSelectedItem().toString()+"");
            }
        });

        btnba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Pantalla_cliente.class));
                finish();
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void abrirCalendario(View view) {
        Calendar cal = Calendar.getInstance();
        int anio = cal.get(Calendar.YEAR);
        int mes =cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        LocalDateTime today = LocalDateTime.now();

        DatePickerDialog dpd = new DatePickerDialog(Reservarmesa.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month , int dayofmonth) {
                String fecha = year + "-" + (month +1) + "-" + dayofmonth;
                tv.setText(fecha);
            }
        }, anio, mes, dia);

        dpd.getDatePicker().setMinDate(System.currentTimeMillis());
        dpd.show();
    }


    public void abrirhora(View view) {
        Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        //int min = c.get(Calendar.MINUTE);

        TimePickerDialog tmd = new TimePickerDialog(Reservarmesa.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourofday, int minute) {
                String horario = hourofday + ":0" + 00;
                hr.setText(horario);
            }
        }, hora, 00, true);

        tmd.show();
    }

    private void incluirreserva(String url){
        final String aux2 = fAuth.getCurrentUser().getEmail();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equalsIgnoreCase("Reserva realizada")) {
                    //Toast.makeText(getApplicationContext(), "Reserva realizada", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Reservarmesa.this, response, Toast.LENGTH_SHORT).show();
                    //Toast.makeText(Reservarmesa.this, "No se realizar reserva", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Reservarmesa.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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