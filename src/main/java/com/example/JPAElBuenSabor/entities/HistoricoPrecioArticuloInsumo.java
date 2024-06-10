package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class HistoricoPrecioArticuloInsumo extends Base{

    private Double precioCosto;
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="articuloInsumo_id")
    private ArticuloInsumo articuloInsumo;
}
