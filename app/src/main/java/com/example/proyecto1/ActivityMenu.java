package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ActivityMenu extends ListActivity {
    String[] menu= {"Documento","Docente","Equipo","Autor","Idioma", "Tipo producto"};
    String[] activities={"CrudLibro","crudDocentes","CrudEquipo","AgregarAutor","AgregarIdioma", "AgregarTipoProducto"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String nombreValue=activities[position];

        l.getChildAt(position).setBackgroundColor(Color.rgb(128,128,255));

        try{
            Class<?> clase=Class.forName("com.example.proyecto1."+nombreValue);
            Intent inte= new Intent(this, clase);
            this.startActivity(inte);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}