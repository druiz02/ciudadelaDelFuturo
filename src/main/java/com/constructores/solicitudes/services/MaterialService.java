package com.constructores.solicitudes.services;

import com.constructores.solicitudes.models.Material;
import com.constructores.solicitudes.repositories.MaterialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    public Material updateMaterial(Material material){
        return materialRepository.save(material);
           }
}

