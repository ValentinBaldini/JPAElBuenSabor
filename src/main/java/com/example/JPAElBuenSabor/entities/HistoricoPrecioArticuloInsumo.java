package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "historicoPrecioArticuloInsumo")
public class HistoricoPrecioArticuloInsumo extends Base{

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "precioCosto")
    private Double precioCosto;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articuloInsumo")
    private ArticuloInsumo articuloInsumo;

}
