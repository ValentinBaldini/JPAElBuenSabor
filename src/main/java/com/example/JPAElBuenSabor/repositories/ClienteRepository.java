package com.example.JPAElBuenSabor.repositories;

import com.example.JPAElBuenSabor.entities.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {
}
