package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.List;

@SuppressLint("NewApi")
public class EliminarLibro extends AppCompatActivity {
    ControlBD helper;
    EditText editTitulo;
    ListView listView;
    static List<Documento> listaDocumento;
    static List<String> lista;
    private final String urlLocal="https://192.168.1.20/Servicios/eliminar_documento.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_libro);
        helper=new ControlBD(this);
        editTitulo=(EditText) findViewById(R.id.editTitulo);
        listView = (ListView) findViewById(R.id.listView1);
    }

    public void eliminar(View v){
        String regEliminadas;
        Documento doc=new Documento();
        doc.setTitulo(editTitulo.getText().toString());
        helper.abrir();
        regEliminadas=helper.eliminar(doc);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

    public void servicioPHP(View v) {
        String titulo = editTitulo.getText().toString();
        String url = "";
        switch (v.getId()) {
            case R.id.eliminarPHP:
                // it was the first button
                url = urlLocal + "?TITULO="+titulo;
                break;
        }
        String documentoLocal =
                ControlServicio.obtenerRespuestaPeticion(url, this);
        try {

            listaDocumento.addAll(ControlServicio.obtenerDocumentoLocal(documentoLocal, this));
            eliminarElementosDuplicados();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarElementosDuplicados() {
        HashSet<Documento> conjuntoDocumento = new HashSet<Documento>();
        conjuntoDocumento.addAll(listaDocumento);
        listaDocumento.clear();
        listaDocumento.addAll(conjuntoDocumento);
        HashSet<String> conjunto = new HashSet<String>();
        conjunto.addAll(lista);
        lista.clear();
        lista.addAll(conjunto);
    }

    public void limpiarTexto(View v) {
        editTitulo.setText("");
    }

    public void regresar (View view){
        Intent regresar = new Intent(this, CrudLibro.class);
        startActivity(regresar);

    }
}