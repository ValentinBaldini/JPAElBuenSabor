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
@Table(name = "promocion")
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "denominacion")
    private String denominacion;

    @Column(name = "fechaDesde")
    private Date fechaDesde;

    @Column(name = "fechaHasta")
    private Date fechaHasta;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_imagen")
    private Imagen id_imagen;

}
