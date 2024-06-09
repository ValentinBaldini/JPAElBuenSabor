package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
//@Inheritance(strategy = InheritanceType.JOINED)
public class Empleado extends Persona {

    @Column(name = "legajo")
    private String legajo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_sucursal")
    private Sucursal sucursal;
}
