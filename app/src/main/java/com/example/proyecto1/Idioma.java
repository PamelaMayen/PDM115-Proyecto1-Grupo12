package com.example.proyecto1;

public class Idioma {
    private int idiomaId;
    private String idiomaNombre;

    public Idioma(){

    }
    public Idioma(int idiomaId, String idiomaNombre){
        this.idiomaId=idiomaId;
        this.idiomaNombre=idiomaNombre;
    }

    public int getIdiomaId() {
        return idiomaId;
    }

    public void setIdiomaId(int idiomaId) {
        this.idiomaId = idiomaId;
    }

    public String getIdiomaNombre() {
        return idiomaNombre;
    }

    public void setIdiomaNombre(String idiomaNombre) {
        this.idiomaNombre = idiomaNombre;
    }
}
