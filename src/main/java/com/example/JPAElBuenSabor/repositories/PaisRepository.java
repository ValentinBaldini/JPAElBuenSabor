package com.example.JPAElBuenSabor.repositories;

import com.example.JPAElBuenSabor.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends BaseRepository<Pais,Long> {
}
