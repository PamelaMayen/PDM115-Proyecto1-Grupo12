package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarIdioma extends Activity {
    ControlBD helper;
    EditText editNombreIdioma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_idioma);
        helper = new ControlBD(this);
        editNombreIdioma=(EditText)findViewById(R.id.editNombreIdioma);
    }

    public void insertarIdioma(View v){
        String nom=editNombreIdioma.getText().toString();
        String regInsertados;
        Idioma idioma = new Idioma();
        idioma.setIdiomaId(0);
        idioma.setIdiomaNombre(nom);
        helper.abrir();
        regInsertados=helper.insertar(idioma);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editNombreIdioma.setText("");
    }
    public void regresar (View view){
        Intent regresar = new Intent(this, ActivityMenu.class);
        startActivity(regresar);

    }
}