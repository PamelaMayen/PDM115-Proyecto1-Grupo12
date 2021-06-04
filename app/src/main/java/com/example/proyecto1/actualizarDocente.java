package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class actualizarDocente extends AppCompatActivity {

    ControlBD helper;
    EditText txtNombreDocente;
    Button btnFinalizarActualizacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_docente);
        helper = new ControlBD(this);
        txtNombreDocente = findViewById(R.id.txtNombreDocenteActualizar);
        txtNombreDocente.setText(getIntent().getStringExtra("txtNombre"));
        btnFinalizarActualizacion = findViewById(R.id.btnFinalizarActualizacion);
    }

    public void actualizar(View v) {
        String nombre = txtNombreDocente.getText().toString();
        Docente docente = new Docente(1, nombre);
        docente.setIdDocente(0);
        docente.setNombreDocente(txtNombreDocente.getText().toString());
        helper.abrir();
        String estado = helper.actualizar(docente);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        txtNombreDocente.setText("");
    }

    public void finalizarActualizacion(){
        btnFinalizarActualizacion.setOnClickListener(v -> {
            if(txtNombreDocente.getText().toString().equals("")) {
                Toast.makeText(actualizarDocente.this, "Debe agregar su nombre completo.", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(actualizarDocente.this, datosGuardadosDocente.class);
                intent.putExtra("txtNombre", txtNombreDocente.getText().toString());
                startActivity(intent);
            }
        });
    }
}