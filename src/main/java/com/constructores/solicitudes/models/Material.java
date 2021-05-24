package com.constructores.solicitudes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Material {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String nombre;
    public double cantidadDisponible;

    

    public double getCantidadDisponible() {
        return cantidadDisponible;
    }
    public void setCantidadDisponible(double cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
