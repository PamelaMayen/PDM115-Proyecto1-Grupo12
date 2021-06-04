package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
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
public class ActualizarLibro extends Activity {
    ControlBD helper;
    EditText editTitulo;
    EditText editTipo;
    EditText editAutor;
    EditText editEditorial;
    EditText editEdicion;
    EditText editIsbn;
    EditText editIdioma;
    ListView listView;
    static List<Documento> listaDocumento;
    static List<String> lista;
    private final String urlLocal="https://192.168.1.20/Servicios/actualizar_documento.php";

    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_libro);
        helper = new ControlBD(this);
        editTitulo = (EditText) findViewById(R.id.editTitulo);
        editTipo = (EditText) findViewById(R.id.editTipo);
        editAutor = (EditText) findViewById(R.id.editAutor);
        editEditorial = (EditText) findViewById(R.id.editEditorial);
        editEdicion = (EditText) findViewById(R.id.editEdicion);
        editIsbn = (EditText) findViewById(R.id.editIsbn);
        editIdioma = (EditText) findViewById(R.id.editIdioma);
        listView = (ListView) findViewById(R.id.listView1);
    }
    public void actualizar(View v) {
        Documento doc = new Documento();
        doc.setEscritoId(0);
        doc.setTitulo(editTitulo.getText().toString());
        doc.setTipoProductoId(Integer.parseInt(editTipo.getText().toString()));
        doc.setAutorId(editAutor.getText().toString());
        doc.setEditorial(editEditorial.getText().toString());
        doc.setEdicion(editEdicion.getText().toString());
        doc.setIsbn(editIsbn.getText().toString());
        doc.setIdiomaId(Integer.parseInt(editIdioma.getText().toString()));
        helper.abrir();
        String estado = helper.actualizar(doc);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void servicioPHP(View v) {
        String titulo = editTitulo.getText().toString();
        int tipo=Integer.parseInt(editTipo.getText().toString());
        String autor=editAutor.getText().toString();
        String editorial=editEditorial.getText().toString();
        String edicion=editEdicion.getText().toString();
        String isbn = editIsbn.getText().toString();
        int idioma = Integer.parseInt(editIdioma.getText().toString());
        String url = "";
        switch (v.getId()) {
            case R.id.actualizarPHP:
                // it was the first button
                url = urlLocal + "?TITULO="+titulo+"?TIPOPRODUCTOID="+tipo+"?AUTORID="+autor+"?EDITORIAL="+editorial
                        +"?EDICION="+edicion+"?ISBN="+isbn+"?IDIOMAID="+idioma;
                break;
        }
        String documentoLocal =
                ControlServicio.obtenerRespuestaPeticion(url, this);
        try {

            listaDocumento.addAll(ControlServicio.obtenerDocumentoLocal(documentoLocal, this));
            actualizarListView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void actualizarListView() {
        String dato = " ";
        lista.clear();
        for (int i = 0; i < listaDocumento.size(); i++) {
            dato = listaDocumento.get(i).getTipoProductoId()+" "+ listaDocumento.get(i).getAutorId()+" "+
                    listaDocumento.get(i).getIdiomaId()+" "+listaDocumento.get(i).getIsbn()+" " +
                    listaDocumento.get(i).getEditorial() + " " + listaDocumento.get(i).getEdicion()+" "+
                    listaDocumento.get(i).getTitulo();
            lista.add(dato);
        }
        eliminarElementosDuplicados();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(adaptador);
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
        editTipo.setText("");
        editAutor.setText("");
        editEdicion.setText("");
        editEditorial.setText("");
        editIsbn.setText("");
        editIdioma.setText("");
    }
    public void regresar (View view){
        Intent regresar = new Intent(this, CrudLibro.class);
        startActivity(regresar);

    }
}