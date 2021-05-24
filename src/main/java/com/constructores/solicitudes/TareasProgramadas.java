package com.constructores.solicitudes;

import java.util.Calendar;
import java.util.Date;

import com.constructores.solicitudes.models.Orden;
import com.constructores.solicitudes.repositories.OrdenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class TareasProgramadas {


    @Autowired
    OrdenRepository ordenRepository;

    @Scheduled(cron = "0 0 6 * * *", zone = "America/Bogota")
    public void tareaOrdenesEnProgreso(){

        Iterable<Orden> ordenes = ordenRepository.findAll();
        Calendar fechaActual = Calendar.getInstance();
        fechaActual.setTime(new Date());
        for(Orden orden: ordenes){
            if( orden.getFechaFinProyecto().compareTo(fechaActual)>=0){
                orden.setEstado("en progreso");  
                ordenRepository.save(orden);

            }
           
        }

    }

    @Scheduled(cron = "0 0 22 * * *", zone = "America/Bogota")
    public void tareaFinalizarOrdenes(){
        Iterable<Orden> ordenes = ordenRepository.findAll();
        Calendar fechaActual = Calendar.getInstance();
        fechaActual.setTime(new Date());
        for(Orden orden: ordenes){
            if( orden.getFechaFinProyecto().compareTo(fechaActual)<0){
                orden.setEstado("finalizado");  
                ordenRepository.save(orden);

            }
           
        }

    }
}
