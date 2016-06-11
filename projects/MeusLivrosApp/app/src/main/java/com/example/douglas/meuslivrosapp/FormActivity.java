package com.example.douglas.meuslivrosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.douglas.meuslivrosapp.data.Db4oFactory;

public class FormActivity extends AppCompatActivity {

    Db4oFactory db4o;

    EditText etTitulo, etAutor, etNumeroPaginas;
    Spinner spCategoria;
    Button btSalvar;

    long livroId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        configurarDb();
        carregarComponentes();
        configurarBotao();
    }

    void configurarDb() {
        String dir = getDir("data", 0) + "/";
        db4o = new Db4oFactory(dir);
    }

    void carregarComponentes() {
        etTitulo = (EditText) findViewById(R.id.et_titulo);
        etAutor = (EditText) findViewById(R.id.et_autor);
        etNumeroPaginas = (EditText) findViewById(R.id.et_numero_paginas);
        spCategoria = (Spinner) findViewById(R.id.sp_categoria);
        btSalvar = (Button) findViewById(R.id.bt_salvar);
    }

    void configurarBotao() {
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        db4o.abrirConexao();
    }

    @Override
    protected void onPause() {
        super.onPause();
        db4o.fecharConexao();
    }
}
