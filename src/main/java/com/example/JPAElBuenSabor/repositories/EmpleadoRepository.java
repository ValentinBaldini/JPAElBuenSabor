package com.example.JPAElBuenSabor.repositories;

import com.example.JPAElBuenSabor.entities.Empleado;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado, Long> {
}