package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CrudLibro extends AppCompatActivity {
    Button actuLib;
    Button agregarLib;
    Button eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_libro);

        actuLib=findViewById(R.id.actuLibro);
        actuLib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CrudLibro.this,ActualizarLibro.class));
                finish();
            }
        });

        agregarLib=findViewById(R.id.agregarLib);
        agregarLib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CrudLibro.this,AgregarLibro.class));
                finish();
            }
        });

        eliminar=findViewById(R.id.eli);
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CrudLibro.this,EliminarLibro.class));
                finish();
            }
        });
    }

    public void Reservar(View view){
        Intent reservar = new Intent(CrudLibro.this, ReservarLibro.class);
        startActivity(reservar);
    }

    public void Regresar (View view){
        Intent regresar = new Intent(this, ActivityMenu.class);
        startActivity(regresar);

    }

}