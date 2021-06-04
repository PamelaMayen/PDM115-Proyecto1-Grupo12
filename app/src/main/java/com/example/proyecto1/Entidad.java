package com.example.proyecto1;

import android.app.Activity;

import java.io.Serializable;

public class Entidad extends Activity implements Serializable {
    private String titulo;
    private String contenido;

    public Entidad() {
    }

    public Entidad(String titulo, String contenido){
        this.titulo=titulo;
        this.contenido=contenido;

    }

    public String getTitulo() {return titulo;}
    public String getContenido() {return contenido;}

}