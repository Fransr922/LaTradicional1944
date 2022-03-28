package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnularReserva extends AppCompatActivity {
    //verresservasparaanularreservas

    Button vermireserva1, vermireserva2, anular;
    EditText anularfecha, anularhora;
    ListView listamireserva;

    FirebaseAuth fAuth;

    CheckBox check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anular_reserva);

        anularfecha = findViewById(R.id.anularfecha);
        anularhora = findViewById(R.id.anularhora);

        vermireserva1 = findViewById(R.id.btnLoadanular1);
        vermireserva2 = findViewById(R.id.btnLoadanular2);
        anular = findViewById(R.id.btnanularreserva);

        fAuth = FirebaseAuth.getInstance();

        listamireserva = findViewById(R.id.lvListaanular);

        check = findViewById(R.id.confcomida);


        vermireserva1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vermireservita1();
            }
        });

        vermireserva2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vermireservita2();

            }
        });

        anular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anularserva();

            }
        });

    }

    public void anularserva() {
        final String fechita = anularfecha.getText().toString().trim();
        final String horita = anularhora.getText().toString().trim();

        if (fechita.isEmpty() || horita.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Rellene campos", Toast.LENGTH_SHORT).show();
        } else {

            if (!check.isChecked()) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.68.106/login/eliminarreserva.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Reserva eliminada correctame", Toast.LENGTH_SHORT).show();
                        //limpiar();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<>();
                        params.put("fecha", anularfecha.getText().toString());
                        params.put("hora", anularhora.getText().toString());
                        return params;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(stringRequest);

            }else{
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.68.106/login/eliminarreservacomida.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Reserva eliminada correctame", Toast.LENGTH_SHORT).show();
                        //limpiar();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<>();
                        params.put("fecha", anularfecha.getText().toString());
                        params.put("hora", anularhora.getText().toString());
                        return params;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(stringRequest);
            }

        }
    }

    public void vermireservita1() {

        final String aux2 = fAuth.getCurrentUser().getEmail();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.68.106/login/verresservasparaanularreservas.php?correo=" + aux2 + "", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                response = response.replace("][", ",");
                if (response.length() > 0) {
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson", "" + ja.length());
                        CargarListViewanular1(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AnularReserva.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }

    public void CargarListViewanular1(JSONArray ja) {

        ArrayList<String> lista = new ArrayList<>();

        for (int i = 0; i < ja.length(); i += 3) {

            try {

                lista.add(ja.getString(i) + "      " + ja.getString(i + 1) + "             " + ja.getString(i + 2) + " ");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listamireserva.setAdapter(adaptador);

    }

    ///////////////////////////////////////////////////////////////////
    public void vermireservita2() {

        final String aux3 = fAuth.getCurrentUser().getEmail();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.68.106/login/verreservasycomidacliente.php?correo=" + aux3 + "", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                response = response.replace("][", ",");
                if (response.length() > 0) {
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson", "" + ja.length());
                        CargarListViewanular2(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AnularReserva.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }


    public void CargarListViewanular2(JSONArray ja) {

        ArrayList<String> lista = new ArrayList<>();

        for (int i = 0; i < ja.length(); i += 4) {

            try {

                lista.add("" + ja.getString(i) + "      " + ja.getString(i + 1) + "             " + ja.getString(i + 2) + "\n COMIDA:" + ja.getString(i + 3));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listamireserva.setAdapter(adaptador);
    }
}