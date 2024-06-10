package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class HistoricoPrecioPromocion extends Base{

    private Date fecha;
    private Double precioPromocional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_promocion")
    private Promocion promocion;


}
