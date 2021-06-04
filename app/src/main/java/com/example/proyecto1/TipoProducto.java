package com.example.proyecto1;

public class TipoProducto {
    private int tipoProductoId;
    private String nombreTipoProducto;
    private Integer categoriaId;


    public TipoProducto(){

    }

    public TipoProducto(int tipoProductoId, String nombreTipoProducto, Integer categoriaId){
        this.tipoProductoId = tipoProductoId;
        this.nombreTipoProducto = nombreTipoProducto;
        this.categoriaId= (Integer) categoriaId;
    }

    public int getTipoProductoId() {
        return tipoProductoId;
    }
    public void setTipoProductoId(int tipoProductoId) {
        this.tipoProductoId = tipoProductoId;
    }
    public String getNombreTipoProducto() {
        return nombreTipoProducto;
    }
    public void setNombreTipoProducto(String nombreTipoProducto) {
        this.nombreTipoProducto = nombreTipoProducto;
    }
    public Number getCategoriaId() {
        return categoriaId;
    }
    public void setCategoriaId(Number categoriaId) {
        this.categoriaId = (Integer) categoriaId;
    }
}
