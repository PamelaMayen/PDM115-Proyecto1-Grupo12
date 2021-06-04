package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CrudEquipo extends AppCompatActivity {
    Button actuEquipo;
    Button agregarEquipo;
    Button eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_equipo);

        actuEquipo=findViewById(R.id.actualizarEquipo);
        actuEquipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CrudEquipo.this,ActualizarEquipo.class));
                finish();
            }
        });

        agregarEquipo=findViewById(R.id.agregarEquipo);
        agregarEquipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CrudEquipo.this,AgregarEquipo.class));
                finish();
            }
        });

        eliminar=findViewById(R.id.eli);
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CrudEquipo.this,EliminarEquipo.class));
                finish();
            }
        });
    }

    public void Regresar (View view){
        Intent regresar = new Intent(this, ActivityMenu.class);
        startActivity(regresar);

    }

}