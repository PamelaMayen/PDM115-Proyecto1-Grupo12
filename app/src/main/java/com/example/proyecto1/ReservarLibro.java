package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ReservarLibro extends AppCompatActivity {
    private ListView ivItems;
    private Adaptador adaptador;
    private ArrayList<Entidad> arrayentidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_libro);

        ivItems =  (ListView) findViewById(R.id.ivItems);
        arrayentidad=GetArrayItems();
        adaptador= new Adaptador(this, arrayentidad);
        ivItems.setAdapter(adaptador);


        ivItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(ReservarLibro.this,DetalleItem.class);
                intent.putExtra("objetoData",arrayentidad.get(position));
                startActivity(intent);
            }
        });
    }

    private ArrayList<Entidad> GetArrayItems(){
        ArrayList<Entidad> listItems = new ArrayList<>();
        listItems.add(new Entidad("EscritoId:","Título:                                            ISBN:                                       Edición:                                   Editorial:                                           Idioma:"));
        listItems.add(new Entidad("EscritoId:","Título:                                            ISBN:                                       Edición:                                   Editorial:                                           Idioma:"));
        listItems.add(new Entidad("EscritoId:","Título:                                            ISBN:                                       Edición:                                   Editorial:                                           Idioma:"));
        listItems.add(new Entidad("EscritoId:","Título:                                            ISBN:                                       Edición:                                   Editorial:                                           Idioma:"));
        listItems.add(new Entidad("EscritoId:","Título:                                            ISBN:                                       Edición:                                   Editorial:                                           Idioma:"));
        listItems.add(new Entidad("EscritoId:","Título:                                            ISBN:                                       Edición:                                   Editorial:                                           Idioma:"));
        listItems.add(new Entidad("EscritoId:","Título:                                            ISBN:                                       Edición:                                   Editorial:                                           Idioma:"));
        listItems.add(new Entidad("EscritoId:","Título:                                            ISBN:                                       Edición:                                   Editorial:                                           Idioma:"));
        listItems.add(new Entidad("EscritoId:","Título:                                            ISBN:                                       Edición:                                   Editorial:                                           Idioma:"));
        listItems.add(new Entidad("EscritoId:","Título:                                            ISBN:                                       Edición:                                   Editorial:                                           Idioma:"));

        return listItems;
    }


    public void Regresar (View view){
        Intent regresar = new Intent(this, CrudLibro.class);
        startActivity(regresar);

    }

}