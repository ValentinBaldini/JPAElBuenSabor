package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "articulo")
public class Articulo extends Base{

    @Column(name = "denominacion")
    private String denominacion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_unidadMedida")
    private UnidadMedida unidadMedida;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_categoria")
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_imagen")
    private Imagen imagen;
}
