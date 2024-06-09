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
@Table(name = "historicoStock")
public class HistoricoStock extends Base {

    @Column(name = "stock")
    private String stock;

    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articuloInsumo")
    private ArticuloInsumo articuloInsumo;
}
