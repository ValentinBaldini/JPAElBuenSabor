package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "horarioPromocionApertura")
public class HorarioPromocionApertura extends Base {

    @Column(name = "hora")
    private int hora;

    @Column(name = "minuto")
    private int minuto;
}
