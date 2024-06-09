package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@SuperBuilder
public class Empleado extends Persona{
    private String legajo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sucursal_id")
    private Sucursal sucursal;
}
