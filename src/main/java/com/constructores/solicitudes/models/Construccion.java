package com.constructores.solicitudes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Construccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private double cantidadDeCeRequerido;
    private double cantidadDeGrRequerido;
    private double cantidadDeArRequerido;
    private double cantidadDeMaRequerido;
    private double cantidadDeAdRequerido;
    private int tiempo;
   

    

    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getCantidadDeCeRequerido() {
        return cantidadDeCeRequerido;
    }
    public void setCantidadDeCeRequerido(double cantidadDeCeRequerido) {
        this.cantidadDeCeRequerido = cantidadDeCeRequerido;
    }
    public double getCantidadDeGrRequerido() {
        return cantidadDeGrRequerido;
    }
    public void setCantidadDeGrRequerido(double cantidadDeGrRequerido) {
        this.cantidadDeGrRequerido = cantidadDeGrRequerido;
    }
    public double getCantidadDeArRequerido() {
        return cantidadDeArRequerido;
    }
    public void setCantidadDeArRequerido(double cantidadDeArRequerido) {
        this.cantidadDeArRequerido = cantidadDeArRequerido;
    }
    public double getCantidadDeMaRequerido() {
        return cantidadDeMaRequerido;
    }
    public void setCantidadDeMaRequerido(double cantidadDeMaRequerido) {
        this.cantidadDeMaRequerido = cantidadDeMaRequerido;
    }
    public double getCantidadDeAdRequerido() {
        return cantidadDeAdRequerido;
    }
    public void setCantidadDeAdRequerido(double cantidadDeAdRequerido) {
        this.cantidadDeAdRequerido = cantidadDeAdRequerido;
    }
    public void setCantidadDeAdRequerido(Long cantidadDeAdRequerido) {
        this.cantidadDeAdRequerido = cantidadDeAdRequerido;
    }
    public int getTiempo() {
        return tiempo;
    }
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
   
    public void setCantidadDeCeRequerido(Long cantidadDeCeRequerido) {
        this.cantidadDeCeRequerido = cantidadDeCeRequerido;
    }
   
    public void setCantidadDeGrRequerido(Long cantidadDeGrRequerido) {
        this.cantidadDeGrRequerido = cantidadDeGrRequerido;
    }
    
    public void setCantidadDeArRequerido(Long cantidadDeArRequerido) {
        this.cantidadDeArRequerido = cantidadDeArRequerido;
    }
  
    public void setCantidadDeMaRequerido(Long cantidadDeMaRequerido) {
        this.cantidadDeMaRequerido = cantidadDeMaRequerido;
    }


    
}
