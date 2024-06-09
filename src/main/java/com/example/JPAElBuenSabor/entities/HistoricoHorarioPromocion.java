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
@Table(name = "historicoHorarioPromocion")
public class HistoricoHorarioPromocion extends Base{

    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_promocion")
    private Promocion promocion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_horarioPromocionApertura")
    private HorarioPromocionApertura horarioPromocionApertura;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_horarioPromocionCierre")
    private HorarioPromocionCierre horarioPromocionCierre;


}
