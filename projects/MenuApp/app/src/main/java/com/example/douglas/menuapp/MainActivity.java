package com.example.douglas.menuapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvItens;
    ArrayAdapter<CharSequence> adapter;
    ArrayList<CharSequence> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItens = (ListView) findViewById(R.id.lv_itens);

        itens = new ArrayList<>();
        itens.add("Item 1");
        itens.add("Item 2");
        itens.add("Item 3");
        itens.add("Item 4");
        itens.add("Item 5");
        itens.add("Item 6");

        adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_activated_1,
                itens);

        lvItens.setAdapter(adapter);
    }
}
