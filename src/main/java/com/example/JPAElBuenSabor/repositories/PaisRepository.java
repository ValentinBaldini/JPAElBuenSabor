package com.example.JPAElBuenSabor.repositories;

import com.example.JPAElBuenSabor.entities.Pais;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaisRepository extends BaseRepository<Pais,Long> {

    @Query("SELECT p " +
            "FROM Pais p " +
            "WHERE :denominacion IS NOT NULL AND LOWER(p.denominacion) LIKE LOWER(CONCAT('%', :denominacion, '%'))")
    List<Pais> buscarPorDenominacion(@Param("denominacion") String denominacion);
}
