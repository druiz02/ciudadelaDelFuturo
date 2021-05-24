package com.constructores.solicitudes.services;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.constructores.solicitudes.models.Construccion;
import com.constructores.solicitudes.models.Material;
import com.constructores.solicitudes.models.Orden;
import com.constructores.solicitudes.repositories.ConstruccionRepository;
import com.constructores.solicitudes.repositories.MaterialRepository;
import com.constructores.solicitudes.repositories.OrdenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrdenService {
    
    @Autowired
    OrdenRepository ordenRepository;

    @Autowired
    ConstruccionRepository construccionRepository;

    @Autowired
    MaterialRepository materialRepository;


        public Iterable<Orden> getInformeDeConstrucciones(){
            return ordenRepository.findAll();
        }


        public Orden solicitarConstruccion(Orden newOrden){

            boolean hayMaterialesEnBodega = true;
            List<Material> nuevosMateriales = new ArrayList();
            Optional<Construccion> construccion = construccionRepository.findById(newOrden.getIdTipoConstruccion());
            Iterable<Material> materiales = materialRepository.findAll();

            if(ordenRepository.existsById(newOrden.getCoordenadas())){
                Orden retorno = new Orden();
                retorno.setCoordenadas(null);
                retorno.setEstado("Error");
                return retorno;
                
               }
            
            

               Calendar fechaActual = Calendar.getInstance();
            fechaActual.setTime(new Date());
            

            for(Material material:materiales){
                Material newMaterial = new Material();
                if(material.getNombre().equals("cemento")){

                    double nuevaCantidad = material.getCantidadDisponible() - construccion.get().getCantidadDeCeRequerido();
                   
                    if(nuevaCantidad>0){
                        newMaterial.setCantidadDisponible(nuevaCantidad);
                        newMaterial.setNombre(material.getNombre());
                        newMaterial.setId(material.getId());
                        nuevosMateriales.add(newMaterial);
                       
                    }else{
                        hayMaterialesEnBodega = false;
                        break;
                    }
                   
                  

                    
                }

                if(material.getNombre().equals("grava")){
                    double nuevaCantidad = material.getCantidadDisponible() - construccion.get().getCantidadDeGrRequerido();
                   
                    if(nuevaCantidad>0){
                        newMaterial.setCantidadDisponible(nuevaCantidad);
                        newMaterial.setNombre(material.getNombre());
                        newMaterial.setId(material.getId());
                        nuevosMateriales.add(newMaterial);
                       
                    }else{
                        hayMaterialesEnBodega = false;
                        break;
                    }
                   
                }

                if(material.getNombre().equals("arena")){
                    double nuevaCantidad = material.getCantidadDisponible() - construccion.get().getCantidadDeArRequerido();
                   
                    if(nuevaCantidad>0){
                        newMaterial.setCantidadDisponible(nuevaCantidad);
                        newMaterial.setNombre(material.getNombre());
                        newMaterial.setId(material.getId());
                        nuevosMateriales.add(newMaterial);
                       
                    }else{
                        hayMaterialesEnBodega = false;
                        break;
                    }
                }

                if(material.getNombre().equals("madera")){
                    double nuevaCantidad = material.getCantidadDisponible() - construccion.get().getCantidadDeMaRequerido();
                   
                    if(nuevaCantidad>0){
                        newMaterial.setCantidadDisponible(nuevaCantidad);
                        newMaterial.setNombre(material.getNombre());
                        newMaterial.setId(material.getId());
                        nuevosMateriales.add(newMaterial);
                       
                    }else{
                        hayMaterialesEnBodega = false;
                        break;
                    }
                }

                if(material.getNombre().equals("adobe")){
                    double nuevaCantidad = material.getCantidadDisponible() - construccion.get().getCantidadDeAdRequerido();
                   
                    if(nuevaCantidad>0){
                        newMaterial.setCantidadDisponible(nuevaCantidad);
                        newMaterial.setNombre(material.getNombre());
                        newMaterial.setId(material.getId());
                        nuevosMateriales.add(newMaterial);
                       
                    }else{
                        hayMaterialesEnBodega = false;
                        break;
                    }
                }


            }

            if(hayMaterialesEnBodega){
                materialRepository.saveAll(nuevosMateriales);
            }else{
                Orden retorno = new Orden();
                retorno.setEstado(null);
                return retorno;
            }


           
            
           
           
           String fechaFinProyecto = ordenRepository.getFechaFin();

         
            Calendar fechaInicioConstruccion = Calendar.getInstance();
            Calendar fechaFinConstruccion = Calendar.getInstance();

            
            fechaInicioConstruccion.setTime(fechaFinProyecto != null?parseFecha(fechaFinProyecto):new Date());

            fechaInicioConstruccion.add(Calendar.DAY_OF_MONTH, 1);

            newOrden.setFechaInicioProyecto(fechaInicioConstruccion);

            fechaFinConstruccion.setTime(fechaInicioConstruccion.getTime());

            fechaFinConstruccion.add(Calendar.DAY_OF_MONTH, construccion.get().getTiempo());

            newOrden.setFechaFinProyecto(fechaFinConstruccion);
            
            newOrden.setEstado("pendiente");
            return ordenRepository.save(newOrden);
           
        }

        private Date parseFecha(String fecha){
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
           
           
                Date fechaDate = formato.parse(fecha, new ParsePosition(0));
           return fechaDate;
            
        }

  


        public String consultarFechaFinProyecto(){
                return ordenRepository.getFechaFin();
        }



}
