package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ReservaEquipo extends AppCompatActivity {

    private ListView ivItems;
    private Adaptador adaptador;
    private ArrayList<Entidad> arrayentidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_equipo);

        ivItems =  (ListView) findViewById(R.id.ivItems);
        arrayentidad=GetArrayItems();
        adaptador= new Adaptador(this, arrayentidad);
        ivItems.setAdapter(adaptador);


        ivItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(ReservaEquipo.this,DetalleItem.class);
                intent.putExtra("objetoData",arrayentidad.get(position));
                startActivity(intent);
            }
        });
    }

    private ArrayList<Entidad> GetArrayItems(){
        ArrayList<Entidad> listItems = new ArrayList<>();
        listItems.add(new Entidad("Equ1","Estado:\nUsuario:\nHora:\nFecha:\n"));
        listItems.add(new Entidad("Equ2","Estado:\nUsuario:\nHora:\nFecha:\n"));
        listItems.add(new Entidad("Equ3","Estado:\nUsuario:\nHora:\nFecha:\n"));
        listItems.add(new Entidad("Equ4","Estado:\nUsuario:\nHora:\nFecha:\n"));
        listItems.add(new Entidad("Equ5","Estado:\nUsuario:\nHora:\nFecha:\n"));

        return listItems;
    }

    public void Regresar (View view){
        Intent regresar = new Intent(this, CrudEquipo.class);
        startActivity(regresar);
    }
}