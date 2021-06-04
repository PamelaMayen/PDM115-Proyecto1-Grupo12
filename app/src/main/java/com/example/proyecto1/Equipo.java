package com.example.proyecto1;

import androidx.annotation.Nullable;

import java.util.Date;

public class Equipo {

    private int equipoId;
    private String equipoGenericoId;
    private int docenteId;
    private int estadoEquipoId;
    private String usuario;
    private int horaId;
    private String codigoEquipo;
    private String fechaAdquisicion;

    public Equipo() {
    }

    public Equipo(int equipoId, String equipoGenericoId, int docenteId, int estadoEquipoId, String usuario, int horaId,
                  String codigoEquipo, String fechaAdquisicion) {
        this.equipoId = equipoId;
        this.equipoGenericoId = equipoGenericoId;
        this.docenteId = docenteId;
        this.estadoEquipoId=estadoEquipoId;
        this.usuario=usuario;
        this.horaId=horaId;
        this.codigoEquipo = codigoEquipo;
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public int getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(int equipoId) {
        this.equipoId = equipoId;
    }

    public String getEquipoGenericoId() {
        return equipoGenericoId;
    }

    public void setEquipoGenericoId(String equipoGenericoId) {
        this.equipoGenericoId = equipoGenericoId;
    }

    public String getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    public String getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(String fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }
    public int getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(int docenteId) {
        this.docenteId = docenteId;
    }

    public int getEstadoEquipoId() {
        return estadoEquipoId;
    }

    public void setEstadoEquipoId(int estadoEquipoId) {
        this.estadoEquipoId = estadoEquipoId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getHoraId() {
        return horaId;
    }

    public void setHoraId(int horaId) {
        this.horaId = horaId;
    }
}
