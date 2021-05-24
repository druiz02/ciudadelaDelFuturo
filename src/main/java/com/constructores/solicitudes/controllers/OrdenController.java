package com.constructores.solicitudes.controllers;

import java.util.ArrayList;

import com.constructores.solicitudes.models.Orden;
import com.constructores.solicitudes.repositories.OrdenRepository;
import com.constructores.solicitudes.services.OrdenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/orden")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;
   // private OrdenRepository ordenRepository;
 
    @RequestMapping(value = "/solicitarConstruccion", method = RequestMethod.POST)
    public Orden solicitarConstruccion(@RequestBody Orden newOrden){

        Orden resultado = ordenService.solicitarConstruccion(newOrden);
        
        if(resultado.getCoordenadas()==null){
            resultado.setCoordenadas("Ya existe una orden en la coordenada ingresada");
        }

        if(resultado.getEstado()==null){
            resultado.setCoordenadas("No se encuentra la cantidad suficiente de materiales para realizar esta orden");
        }

       
        return resultado;
    }

    
    @RequestMapping(value = "/consultarFechaFin", method = RequestMethod.GET)
    public String consultarFechaFinProyecto(){
        return ordenService.consultarFechaFinProyecto();
    }



    @RequestMapping(value = "/informeDeConstrucciones", method = RequestMethod.GET)
    public Iterable<Orden> getInformeDeConstrucciones(){
        
        return ordenService.getInformeDeConstrucciones();
    }
}
