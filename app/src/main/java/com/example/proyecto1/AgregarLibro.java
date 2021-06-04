package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

@SuppressLint("NewApi")
public class AgregarLibro extends Activity {

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
    private final String urlLocal="https://192.168.1.20/Servicios/agregar_documento.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_libro);
        helper = new ControlBD(this);
        editTitulo = (EditText) findViewById(R.id.editTitulo);
        editTipo= (EditText) findViewById(R.id.editTipo);
        editAutor = (EditText) findViewById(R.id.editAutor);
        editEditorial = (EditText) findViewById(R.id.editEditorial);
        editEdicion = (EditText) findViewById(R.id.editEdicion);
        editIsbn = (EditText) findViewById(R.id.editIsbn);
        editIdioma = (EditText) findViewById(R.id.editIdioma);
        listView = (ListView) findViewById(R.id.listView1);
    }

    public void insertar(View v){
        String titulo=editTitulo.getText().toString();
        int tipoP=Integer.parseInt(editTipo.getText().toString());
        String autorN=editAutor.getText().toString();
        String editorial=editEditorial.getText().toString();
        String edicion=editEdicion.getText().toString();
        String isbn=editIsbn.getText().toString();
        int idioma=Integer.parseInt(editIdioma.getText().toString());
        String regInsertados;
        Documento documento = new Documento();
        documento.setEscritoId(0);
        documento.setTitulo(titulo);
        documento.setTipoProductoId(tipoP);
        documento.setAutorId(autorN);
        documento.setEditorial(editorial);
        documento.setEdicion(edicion);
        documento.setIsbn(isbn);
        documento.setIdiomaId(idioma);
        helper.abrir();
        regInsertados=helper.insertar(documento);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
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
            case R.id.agregarPHP:
                // it was the first button
                url = urlLocal + "?TITULO="+titulo+"?TIPOPRODUCTOID="+tipo+"?AUTORID="+autor+"?EDITORIAL="+editorial
                        +"?EDICION="+edicion+"?ISBN="+isbn+"?IDIOMAID="+idioma;
                ControlServicio.insertarDocumentoLocal(url, this);
                break;
        }
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