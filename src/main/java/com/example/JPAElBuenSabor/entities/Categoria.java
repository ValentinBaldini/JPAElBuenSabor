package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "categoria")
public class Categoria extends Base{

    @Column(name = "denominacion")
    private String denominacion;

    @Column(name = "esInsumo")
    private Boolean esInsumo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_categoria")
    private Categoria categoria;
}
