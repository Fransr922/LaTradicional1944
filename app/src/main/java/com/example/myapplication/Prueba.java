package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Prueba extends AppCompatActivity {
    TextView aa,txt5;
    Button bb,btn2;

    private ListView owo;
    List<String> it;
    ArrayAdapter AADDPP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);

        aa = findViewById(R.id.com2);
        txt5 = findViewById(R.id.com1);

        bb = findViewById(R.id.an2);
        btn2 = findViewById(R.id.an1);

        owo = findViewById(R.id.listaprueba);
        it = new ArrayList<>();
        AADDPP = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, it);

        owo.setAdapter(AADDPP);
        owo.setBackgroundColor(Color.DKGRAY);

        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.add(aa.getText().toString());
                AADDPP.notifyDataSetChanged();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.add(txt5.getText().toString());
                AADDPP.notifyDataSetChanged();
            }
        });
    }
}