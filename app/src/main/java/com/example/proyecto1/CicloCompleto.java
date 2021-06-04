package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CicloCompleto extends AppCompatActivity {



    private Button miBoton;

    private TextView titulo, informacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_completo);







        miBoton=(Button) findViewById(R.id.button4);
        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast .makeText(getApplicationContext(),"Se ha reservado el documento", Toast.LENGTH_LONG).show();
                Intent regresar1 = new Intent(CicloCompleto.this,ReservarLibro.class);
                startActivity(regresar1);
            }
        });

    }

    public void Regresar1 (View view){
        Intent regresar1 = new Intent(CicloCompleto.this, DetalleItem.class);
        startActivity(regresar1);



    }



}