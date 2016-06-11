package com.example.douglas.meuslivrosapp.data;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Db4oFactory {
    private final String DB4O_FILE = "bd.db4o";

    private String dir;
    public ObjectContainer db;

    public Db4oFactory(String dir) {
        this.dir = dir;
    }

    public void abrirConexao() {
        String dbFile = dir + DB4O_FILE;
        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dbFile);
    }

    public void fecharConexao() {
        if (db != null) {
            db.close();
        }
    }
}
