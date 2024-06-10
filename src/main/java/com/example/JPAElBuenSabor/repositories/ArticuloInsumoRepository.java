package com.example.JPAElBuenSabor.repositories;

import com.example.JPAElBuenSabor.entities.ArticuloInsumo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo,Long>{
    @Query("SELECT ai " +
            "FROM ArticuloInsumo ai " +
            "WHERE :denominacion IS NOT NULL AND LOWER(ai.denominacion) LIKE LOWER(CONCAT('%', :denominacion, '%'))")
    List<ArticuloInsumo> searchByDenominacion(@Param("denominacion") String denominacion);

    @Query("SELECT ai " +
            "FROM ArticuloInsumo ai " +
            "WHERE :denominacion IS NOT NULL AND LOWER(ai.denominacion) LIKE LOWER(CONCAT('%', :denominacion, '%'))")
    List<ArticuloInsumo> getByName (@Param("denominacion") String denominacion);
}
