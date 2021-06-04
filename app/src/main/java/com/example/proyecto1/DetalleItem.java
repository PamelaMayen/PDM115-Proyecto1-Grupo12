package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleItem extends AppCompatActivity {

    public Entidad Item;
    private TextView titulo, informacion;
    //private Button miBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detalle_item);
        Item = (Entidad) getIntent().getSerializableExtra("objetoData");

        titulo=(TextView) findViewById(R.id.titulo);
        informacion=(TextView) findViewById(R.id.informacion0);

        titulo.setText(Item.getTitulo());
        informacion.setText(Item.getContenido());

        /*miBoton=(Button) findViewById(R.id.button2);
        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast .makeText(getApplicationContext(),"Se ha reservado el libro",Toast.LENGTH_LONG).show();
            }
        });*/
    }

    public void Regresar (View view){
        Intent regresar = new Intent(DetalleItem.this, ReservarLibro.class);
        startActivity(regresar);

    }

    public void ReservarCiclo(View view){
        Intent reservarCiclo = new Intent(DetalleItem.this, CicloCompleto.class);
        startActivity(reservarCiclo);
    }

    public void ReservarActividad(View view){
        Intent reservarActividad = new Intent(DetalleItem.this,Actividad.class);
        startActivity(reservarActividad);

    }
}