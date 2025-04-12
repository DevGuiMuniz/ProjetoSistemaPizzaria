package com.example.projetoex05;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CheckBox checkCalabresa, checkMarguerita, checkPortuguesa;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkCalabresa = findViewById(R.id.checkCalabresa);
        checkMarguerita = findViewById(R.id.checkMarguerita);
        checkPortuguesa = findViewById(R.id.checkPortuguesa);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(v -> {
            ArrayList<String> pizzas = new ArrayList<>();

            if (checkCalabresa.isChecked()) pizzas.add("Calabresa");
            if (checkMarguerita.isChecked()) pizzas.add("Marguerita");
            if (checkPortuguesa.isChecked()) pizzas.add("Portuguesa");

            Intent intent = new Intent(MainActivity.this, activity_tamanho_pagamento.class);
            intent.putStringArrayListExtra("pizzas", pizzas);
            startActivity(intent);
        });
    }
}
