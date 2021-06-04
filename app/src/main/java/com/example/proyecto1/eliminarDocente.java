package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class eliminarDocente extends AppCompatActivity {

    ControlBD helper;
    Button btnEliminar;
    EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_docente);
        helper =new ControlBD(this);
        nombre=(EditText) findViewById(R.id.nombre);
        btnEliminar = findViewById(R.id.btnEliminarDocente);
    }

    public void eliminar(View v){
        String regEliminadas;
        Docente docente = new Docente();
        docente.setNombreDocente(nombre.getText().toString());
        helper.abrir();
        regEliminadas=helper.eliminar(docente);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(eliminarDocente.this, crudDocentes.class);
                    startActivity(intent);
                }
        });
    }

    public void limpiarTexto(View v) {
        nombre.setText("");
    }
}