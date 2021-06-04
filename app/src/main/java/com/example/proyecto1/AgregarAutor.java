package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarAutor extends Activity {

    ControlBD helper;
    EditText editNombreAutor;
    EditText editApeAutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_autor);
        helper = new ControlBD(this);
        editNombreAutor=(EditText)findViewById(R.id.editNombreAutor);
        editApeAutor=(EditText)findViewById(R.id.editApeAutor);
    }

    public void insertarAutor(View v){
        String nom=editNombreAutor.getText().toString();
        String ape=editApeAutor.getText().toString();
        String regInsertados;
        Autor autor= new Autor();
        autor.setAutorId("0");
        autor.setNomAutor(nom);
        autor.setApeAutor(ape);
        helper.abrir();
        regInsertados=helper.insertar(autor);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editNombreAutor.setText("");
        editApeAutor.setText("");
    }
    public void regresar (View view){
        Intent regresar = new Intent(this, ActivityMenu.class);
        startActivity(regresar);

    }
}