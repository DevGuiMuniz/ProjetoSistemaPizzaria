package com.example.projetoex05;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class activity_resumo_pedido extends AppCompatActivity {

    TextView txtResumo;
    Button btnNovoPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pedido);

        txtResumo = findViewById(R.id.txtResumo);
        btnNovoPedido = findViewById(R.id.btnNovoPedido);

        ArrayList<String> pizzas = getIntent().getStringArrayListExtra("pizzas");
        String tamanho = getIntent().getStringExtra("tamanho");
        String pagamento = getIntent().getStringExtra("pagamento");
        double preco = getIntent().getDoubleExtra("preco", 0);

        String resumo = "Pedido:\n";
        for (String p : pizzas) {
            resumo += "- " + p + "\n";
        }
        resumo += "\nTamanho: " + tamanho;
        resumo += "\nPagamento: " + pagamento;
        resumo += "\nValor Total: R$ " + preco;

        txtResumo.setText(resumo);

        btnNovoPedido.setOnClickListener(v -> {
            Intent intent = new Intent(activity_resumo_pedido.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}
