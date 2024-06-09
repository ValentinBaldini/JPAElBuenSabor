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
public class HorarioCierre extends Base{

    private Integer hora;
    private Integer minuto;
}
