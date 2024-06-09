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
public class HistoricoHorario extends Base{

    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "horario_apertura_id")
    private HorarioApertura horarioApertura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "horario_cierre_id")
    private HorarioCierre horarioCierre;
}
