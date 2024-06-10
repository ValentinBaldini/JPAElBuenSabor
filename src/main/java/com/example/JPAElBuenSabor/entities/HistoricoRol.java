package com.example.JPAElBuenSabor.entities;

import com.example.JPAElBuenSabor.entities.enums.Rol;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class HistoricoRol extends Base{

    private Date fecha;
    @Enumerated(EnumType.STRING)
    private Rol rol;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rol_id")
    private Rol rol;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="persona_id")
    private Persona persona;
}
