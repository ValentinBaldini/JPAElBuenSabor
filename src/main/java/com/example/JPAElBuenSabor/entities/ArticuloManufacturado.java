package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "articuloManufacturado")
public class ArticuloManufacturado extends Base{

    @Column(name = "tiempoEstimadoEnMinutos")
    private int tiempoEstimadoEnMinutos;

    @Column(name = "preparacion")
    private String preparacion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articulo")
    private Articulo articulo;
}
