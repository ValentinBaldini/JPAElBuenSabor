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
@Table(name = "articuloInsumo")
public class ArticuloInsumo extends Base {

    @Column(name = "stockMaximo")
    private int stockMaximo;

    @Column(name = "stockMinimo")
    private int stockMinimo;

    @Column(name = "esParaElaborar")
    private boolean esParaElaborar;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articulo")
    private Articulo articulo;
}
