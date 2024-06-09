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
public class Empresa extends Base{

    private String nombre;
    private String razonSocial;
    private String cuil;
}
