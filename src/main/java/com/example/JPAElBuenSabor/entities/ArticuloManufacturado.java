package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class ArticuloManufacturado extends Articulo{

    private Integer tiempoEstimadoEnMinutos;
    private String Preparacion;

}
