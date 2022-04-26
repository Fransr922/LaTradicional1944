package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class Visualizarpedidoaprepararmesa extends AppCompatActivity {

    ListView listaprep;
    Button atrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizarpedidoaprepararmesa);

        listaprep = findViewById(R.id.listaaentregarsita3mes);
        atrs = findViewById(R.id.btnhihimes);


        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.68.117/login/vercomidaaprepararmesa.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                response = response.replace("][", ",");
                if (response.length() > 0) {
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson", "" + ja.length());
                        Cargarprepmes(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Visualizarpedidoaprepararmesa.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);

        atrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Pantalla_cocinero.class));
            }
        });

    }

    public void Cargarprepmes(JSONArray ja) {

        ArrayList<String> lista = new ArrayList<>();

        for (int i = 0; i < ja.length(); i += 4) {

            try {

                lista.add(ja.getString(i) + "                               " + ja.getString(i + 1) + "                             " + ja.getString(i + 2) + "\n COMIDA: " + ja.getString(i + 3));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listaprep.setAdapter(adaptador);

    }
}