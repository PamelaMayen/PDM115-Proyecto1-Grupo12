package com.example.proyecto1;

public class Documento {
    private int escritoId;
    private String isbn;
    private String edicion;
    private String editorial;
    private String titulo;
    private int tipoProductoId;
    private String autorId;
    private int idiomaId;

    public Documento(){

    }
    public Documento(int escritoId, String isbn, String edicion, String editorial, String titulo){
        this.escritoId=escritoId;
        this.isbn=isbn;
        this.edicion=edicion;
        this.editorial=editorial;
        this.titulo=titulo;
    }
    public int getEscritoId(){
        return escritoId;
    }
    public void setEscritoId(int escritoId){
        this.escritoId=escritoId;
    }
    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn=isbn;
    }
    public String getEdicion(){
        return edicion;
    }
    public void setEdicion(String edicion){
        this.edicion=edicion;
    }
    public String getEditorial(){
        return editorial;
    }
    public void setEditorial(String editorial){
        this.editorial=editorial;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    public int getTipoProductoId() { return tipoProductoId; }
    public void setTipoProductoId(int tipoProductoId) { this.tipoProductoId=tipoProductoId; }
    public String getAutorId() {
        return autorId;
    }
    public void setAutorId(String autorId) {
        this.autorId = autorId;
    }
    public int getIdiomaId() {
        return idiomaId;
    }
    public void setIdiomaId(int idiomaId) {
        this.idiomaId = idiomaId;
    }
}
