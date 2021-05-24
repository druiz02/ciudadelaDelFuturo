package com.constructores.solicitudes.models;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Orden {
    
    @Id
    private String coordenadas;
    private String estado;
    private Long idTipoConstruccion;

    @Basic
    @Temporal(TemporalType.DATE)
    private Calendar fechaFinProyecto;

    @Basic
    @Temporal(TemporalType.DATE)
    private Calendar fechaInicioProyecto;
    

    

    public Orden() {
    }

    





public Calendar getFechaFinProyecto() {
        return fechaFinProyecto;
    }







    public void setFechaFinProyecto(Calendar fechaFinProyecto) {
        this.fechaFinProyecto = fechaFinProyecto;
    }







    public Calendar getFechaInicioProyecto() {
        return fechaInicioProyecto;
    }







    public void setFechaInicioProyecto(Calendar fechaInicioProyecto) {
        this.fechaInicioProyecto = fechaInicioProyecto;
    }








    public String getCoordenadas() {
        return coordenadas;
    }
    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Long getIdTipoConstruccion() {
        return idTipoConstruccion;
    }
    public void setIdTipoConstruccion(Long idTipoConstruccion) {
        this.idTipoConstruccion = idTipoConstruccion;
    }



    
}
