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
public class HistoricoHorarioPromocion extends Base{

    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promocion_id")
    private Promocion promocion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "horario_promocion_apertura_id")
    private HorarioPromocionApertura horarioPromocionApertura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "horario_promocion_cierre_id")
    private HorarioPromocionCierre horarioPromocionCierre;


}
