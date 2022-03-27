package com.example.myapplication;

import android.annotation.SuppressLint;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class reservarcomidaymesa extends AppCompatActivity {

    TextView fe,ho,obj1,obj2,obj3,obj4, txt;
    Button ani1,ani2,ani3,ani4, btnreservar, btnaattrraass;

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

        obj1 = findViewById(R.id.com1);
        obj2 = findViewById(R.id.com2);
        obj3 = findViewById(R.id.com3);
        obj4 = findViewById(R.id.com4);

        ani1 = findViewById(R.id.an1);
        ani2 = findViewById(R.id.an2);
        ani3 = findViewById(R.id.an3);
        ani4 = findViewById(R.id.an4);
        btnreservar = findViewById(R.id.btnreservamesaycomida);
        btnaattrraass = findViewById(R.id.btnatrss);

        fAuth = FirebaseAuth.getInstance();

        lista = findViewById(R.id.listacomidaselect);
        items = new ArrayList<>();
        ADP = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, items);
        lista.setAdapter(ADP);
        lista.setBackgroundColor(Color.DKGRAY);

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
                //Toast.makeText(reservarcomidaymesa.this, "Reserva realizada " + per,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ani1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(obj1.getText().toString());
                ADP.notifyDataSetChanged();
            }
        });

        ani2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(obj2.getText().toString());
                ADP.notifyDataSetChanged();
            }
        });

        ani3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(obj3.getText().toString());
                ADP.notifyDataSetChanged();
            }
        });

        ani4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(obj4.getText().toString());
                ADP.notifyDataSetChanged();
            }
        });

        btnreservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(getApplicationContext(), "Total number of Items are:" + lista.getAdapter().getCount() , Toast.LENGTH_LONG).show();
                for (int i = 0; i < lista.getAdapter().getCount(); i++) {
                    //txt.setText((String)lista.getItemAtPosition(i));
                    txt.setText(txt.getText() + " " + (String)lista.getItemAtPosition(i));
                }

                aniadirreserva("http://192.168.68.106/login/reservarcomida.php?fecha="+fe.getText()+""+"&hora="+ho.getText()+""+"&personas="+Spersons.getSelectedItem().toString()+""+"&comida="+txt.getText()+"");

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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void abrirCalendar(View view) {

        Calendar cal = Calendar.getInstance();
        int anio = cal.get(Calendar.YEAR);
        int mes =cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        LocalDateTime today = LocalDateTime.now();

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
        ArrayList<String> xa = new ArrayList<String>();
        for (int i = 0; i < lista.getCount(); i++) {
                xa.add((String) lista.getItemAtPosition(i));
        }

        for(int i = 0; i < xa.size(); i++) {
            System.out.println(xa.get(i));
        }

        if (fe.getText().toString().equals("Fecha") || ho.getText().toString().equals("Hora") || txt.getText().toString().equals("")){
            Toast.makeText(this, "Campos vacíos", Toast.LENGTH_SHORT).show();
        }else {

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {


                    if (response.equalsIgnoreCase("Reserva realizada")) {
                        //Toast.makeText(getApplicationContext(), "Reserva realizada", Toast.LENGTH_SHORT).show();
                        limpiaar();

                    } else {
                        Toast.makeText(reservarcomidaymesa.this, response, Toast.LENGTH_SHORT).show();
                        //Toast.makeText(Reservarmesa.this, "No se realizar reserva", Toast.LENGTH_SHORT).show();
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

    @SuppressLint("SetTextI18n")
    private void limpiaar(){
        txt.setText("");
        fe.setText("Fecha");
        ho.setText("Hora");
        //items.clear();
        ADP.clear();

    }

}

