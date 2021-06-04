package com.example.proyecto1;

public class Usuario {
    private String usuario;
    private String contrasena;
    private String nombreUsuario;

    public Usuario(){

    }
    public Usuario(String usuario, String contrasena, String nombreUsuario){
        this.usuario=usuario;
        this.contrasena=contrasena;
        this.nombreUsuario=nombreUsuario;
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
