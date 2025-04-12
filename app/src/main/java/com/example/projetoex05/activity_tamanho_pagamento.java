package com.example.projetoex05;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class activity_tamanho_pagamento extends AppCompatActivity {

    RadioGroup groupTamanho, groupPagamento;
    Button btnConfirmar;
    ArrayList<String> pizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamanho_pagamento);

        pizzas = getIntent().getStringArrayListExtra("pizzas");

        groupTamanho = findViewById(R.id.groupTamanho);
        groupPagamento = findViewById(R.id.groupPagamento);
        btnConfirmar = findViewById(R.id.btnFinalizarPedido);

        btnConfirmar.setOnClickListener(v -> {
            int tamanhoId = groupTamanho.getCheckedRadioButtonId();
            int pagamentoId = groupPagamento.getCheckedRadioButtonId();

            String tamanho = ((RadioButton)findViewById(tamanhoId)).getText().toString();
            String pagamento = ((RadioButton)findViewById(pagamentoId)).getText().toString();

            double preco = 0;
            if (tamanho.contains("Pequena")) preco = 25;
            else if (tamanho.contains("Média")) preco = 35;
            else if (tamanho.contains("Grande")) preco = 45;

            Intent intent = new Intent(activity_tamanho_pagamento.this, activity_resumo_pedido.class);
            intent.putStringArrayListExtra("pizzas", pizzas);
            intent.putExtra("tamanho", tamanho);
            intent.putExtra("pagamento", pagamento);
            intent.putExtra("preco", preco);
            startActivity(intent);
        });
    }
}
