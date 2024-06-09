package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Email extends Base{
    private String correo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="persona_id")
    private Persona persona;
}
