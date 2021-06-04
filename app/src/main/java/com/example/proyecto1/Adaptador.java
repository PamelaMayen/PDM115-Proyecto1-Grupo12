package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private Context context;
    private ArrayList<Entidad> listItems;

    public Adaptador() {
    }

    public Adaptador(Context context, ArrayList<Entidad> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    //metodo que le indicará al listview cuantos datos se van a cargar / esta asociado al arraylist
    public int getCount() {
        return listItems.size();
    }

    @Override
    //le va a devolver del listitem la posicion que es el parametro que esta recibiendo
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    //no se usará
    public long getItemId(int position) {
        return 0;
    }

    @Override
    //metodo donde se creará cada item y donde se asignará los valores de cada elemento de cada item
    public View getView(int position, View convertView, ViewGroup parent) {
        Entidad Item=(Entidad) getItem(position);
        convertView= LayoutInflater.from(context).inflate(R.layout.item,null);
        TextView titulo = (TextView) convertView.findViewById(R.id.titulo);
        TextView contenido = (TextView) convertView.findViewById(R.id.contenido);

        titulo.setText(Item.getTitulo());
        contenido.setText(Item.getContenido());


        return convertView;
    }
}