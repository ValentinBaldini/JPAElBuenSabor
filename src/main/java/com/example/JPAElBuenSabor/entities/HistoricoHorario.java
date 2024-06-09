package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "historico_horario")
public class HistoricoHorario extends Base{


    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_sucursal")
    private Sucursal sucursal;

    @ManyToOne(cascade =  CascadeType.PERSIST)
    @JoinColumn(name = "fk_horario_apertura")
    private HorarioApertura horarioApertura;

    @ManyToOne(cascade =  CascadeType.PERSIST)
    @JoinColumn(name = "fk_horario_cierre")
    private HorarioCierre horarioCierre;

}
