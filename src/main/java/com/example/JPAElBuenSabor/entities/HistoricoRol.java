package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "historico_rol")
public class HistoricoRol extends Base{

    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_rol")
    private Rol rol;

    /*@ManyToOne(cascade =  CascadeType.PERSIST)
    @JoinColumn(name = "fk_persona")
    private Persona persona;*/
}
