package com.constructores.solicitudes.repositories;

import com.constructores.solicitudes.models.Orden;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends CrudRepository<Orden, String> {
    

    @Query(value = "SELECT max(fecha_fin_proyecto) FROM orden", nativeQuery = true)
    String getFechaFin();
}
