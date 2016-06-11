package com.example.douglas.meuslivrosapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.douglas.meuslivrosapp.data.Db4oFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String BUNDLE_LIVRO_ID = "livro_id";

    Db4oFactory db4o;

    ListView lvLivros;
    List<Livro> livros;
    LivroAdapter adapter;

    EditText etFiltro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configurarDb();
        configurarLista();
    }

    void configurarDb() {
        String dir = getDir("data", 0) + "/";
        db4o = new Db4oFactory(dir);
    }

    void configurarLista() {
        lvLivros = (ListView) findViewById(R.id.lv_livros);
        livros = new ArrayList<>();
        adapter = new LivroAdapter(MainActivity.this, livros);
        lvLivros.setAdapter(adapter);
        lvLivros.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        lvLivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });

        lvLivros.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            List<Livro> selecionados;

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                Livro livro = livros.get(position);

                if (checked) {
                    selecionados.add(livro);
                }
                else {
                    selecionados.remove(livro);
                }

                int total = selecionados.size();
                mode.setTitle(Integer.toString(total));

                adapter.setSelectedItems(selecionados);
                adapter.notifyDataSetChanged();
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.livros, menu);
                selecionados = new ArrayList<>();
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(final ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_excluir_livros:

                        new AlertDialog.Builder(MainActivity.this)
                                .setMessage(getString(R.string.confirma_exclusao))
                                .setNegativeButton(getString(R.string.nao), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                })
                                .setPositiveButton(getString(R.string.sim), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                })
                                .create()
                                .show();

                        return true;
                }

                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                selecionados.clear();
                adapter.setSelectedItems(selecionados);
                adapter.notifyDataSetChanged();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_novo_livro:
                Intent i = new Intent(MainActivity.this, FormActivity.class);
                startActivity(i);
                return true;

            case R.id.menu_excluir_todos:
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage(getString(R.string.confirma_exclusao_todos))
                        .setNegativeButton(getString(R.string.nao), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setPositiveButton(getString(R.string.sim), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .create()
                        .show();
                return true;
        }

        return false;
    }
}
