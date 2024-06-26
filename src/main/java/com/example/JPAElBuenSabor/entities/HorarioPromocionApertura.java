package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class HorarioPromocionApertura extends Base {

    private int hora;
    private int minuto;
}
