package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@SuperBuilder
public class ArticuloManufacturado extends Articulo{

    private Integer tiempoEstimadoEnMinutos;
    private String Preparacion;

}
