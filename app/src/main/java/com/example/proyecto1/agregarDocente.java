package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class agregarDocente extends AppCompatActivity {

    ControlBD helper;
    Button btnFinalizar;
    EditText txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper = new ControlBD(this);
        setContentView(R.layout.activity_agregar_docente);
        txtNombre = findViewById(R.id.editTextNombreDocente);
        btnFinalizar = findViewById(R.id.btnAgregarDocenteFinalizar);
    }

    public void insertar(View v) {
        String nombre = txtNombre.getText().toString();
        String regInsertados;
        Docente docente = new Docente();
        docente.setIdDocente(0);
        docente.setNombreDocente(nombre);
        helper.abrir();
        regInsertados = helper.insertar(docente);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        txtNombre.setText("");
    }

    public void finalizar(View view) {
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNombre.getText().toString().equals("")) {
                    Toast.makeText(agregarDocente.this, "Debe agregar su nombre completo", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(agregarDocente.this, datosGuardadosDocente.class);
                    intent.putExtra("txtNombre", txtNombre.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}