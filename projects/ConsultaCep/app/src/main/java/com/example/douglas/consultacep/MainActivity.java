package com.example.douglas.consultacep;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    final String API_URL = "http://correiosapi.apphb.com/";

    EditText etCep;
    Button btConsultar;
    TextView tvResultado;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregarViews();

        btConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private void carregarViews() {
        btConsultar = (Button) findViewById(R.id.bt_consultar);
        etCep = (EditText) findViewById(R.id.et_cep);
        tvResultado = (TextView) findViewById(R.id.tv_resultado);
    }
}
