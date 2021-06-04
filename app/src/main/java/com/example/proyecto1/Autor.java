package com.example.proyecto1;

public class Autor {
    private String autorId;
    private String nomAutor;
    private String apeAutor;

    public Autor(){

    }
    public Autor(String autorId, String nomAutor, String apeAutor){
        this.autorId=autorId;
        this.nomAutor=nomAutor;
        this.apeAutor=apeAutor;
    }

    public String getAutorId() {
        return autorId;
    }

    public void setAutorId(String autorId) {
        this.autorId = autorId;
    }

    public String getNomAutor() {
        return nomAutor;
    }

    public void setNomAutor(String nomAutor) {
        this.nomAutor = nomAutor;
    }

    public String getApeAutor() {
        return apeAutor;
    }

    public void setApeAutor(String apeAutor) {
        this.apeAutor = apeAutor;
    }
}
