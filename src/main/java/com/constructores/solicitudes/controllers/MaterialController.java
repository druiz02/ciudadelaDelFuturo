package com.constructores.solicitudes.controllers;

import com.constructores.solicitudes.models.Material;
import com.constructores.solicitudes.repositories.MaterialRepository;
import com.constructores.solicitudes.services.MaterialService;
import com.constructores.solicitudes.services.OrdenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/materiales")
public class MaterialController {
    
    @Autowired
    private MaterialService materialService;
    //private MaterialRepository materialRepository;


    @RequestMapping(value = "/cargarMaterial", method = RequestMethod.PUT)
    public Material cargarMateriales(@RequestBody Material material){

       return materialService.updateMaterial(material);
    }


    @RequestMapping(value = "/crearMaterial", method = RequestMethod.POST)
    public Material crearMaterial(@RequestBody Material material){

       return materialService.updateMaterial(material);
    }

}
