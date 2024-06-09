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
@Table(name = "horario_apertura")
public class HorarioApertura extends Base{


    @Column(name = "hora")
    private int hora;

    @Column(name = "minutos")
    private int minutos;
}