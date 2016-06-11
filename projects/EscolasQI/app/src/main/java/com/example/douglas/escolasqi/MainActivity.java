package com.example.douglas.escolasqi;

import android.app.ProgressDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    final String API_URL = "http://schoollineup.apphb.com/api/";

    ListView lvEscolas;
    ArrayAdapter<Escola> adapter;
    List<Escola> escolas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configurarLista();
    }

    void configurarLista() {
        lvEscolas = (ListView) findViewById(R.id.lv_escolas);

        escolas = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                MainActivity.this, android.R.layout.simple_list_item_1, escolas
        );

        lvEscolas.setAdapter(adapter);
    }
}
