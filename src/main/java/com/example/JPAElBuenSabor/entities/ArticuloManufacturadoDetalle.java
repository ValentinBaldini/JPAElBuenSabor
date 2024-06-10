package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class ArticuloManufacturadoDetalle extends Base{

    private Double cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="articuloInsumo_id")
    private ArticuloInsumo articuloInsumo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="articuloManufacturado_id")
    private ArticuloManufacturado articuloManufacturado;
}
