package com.example.douglas.produtosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProdutosActivity extends AppCompatActivity {

    final static String BUNDLE_PRODUTO = "produto";

    ListView lvProdutos;
    ArrayList<Produto> produtos;
    ArrayAdapter<Produto> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        configurarLvProdutos();

        // TODO: pegar a categoria recebida

        // TODO: alterar título com o nome da categoria

        // TODO: carregar produtos da categoria
    }

    private void configurarLvProdutos() {
        lvProdutos = (ListView) findViewById(R.id.lv_produtos);

        produtos = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                ProdutosActivity.this,
                android.R.layout.simple_list_item_1,
                produtos
        );

        lvProdutos.setAdapter(adapter);

        lvProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO: abrir activity de detalhes do produto
            }
        });
    }

    // TODO: tratar retorno
}
