package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Actividad extends AppCompatActivity {
    private Button miBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad);

        miBoton=(Button) findViewById(R.id.button4);
        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Se ha reservado el documento", Toast.LENGTH_LONG).show();
                Intent regresar2 = new Intent(Actividad.this,ReservarLibro.class);
                startActivity(regresar2);
            }
        });


    }

    public void Regresar2 (View view){
        Intent regresar2 = new Intent(Actividad.this, DetalleItem.class);
        startActivity(regresar2);

    }
}