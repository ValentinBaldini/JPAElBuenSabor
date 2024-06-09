package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
//@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente extends Persona{

    @Column(name = "dinero_inicial")
    private String dinero;

}
