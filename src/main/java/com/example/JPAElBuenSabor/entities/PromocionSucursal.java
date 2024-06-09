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
@Table(name = "promocionSucursal")
public class PromocionSucursal extends Base{

    @Column(name = "estaActivo")
    private boolean estaActivo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_sucursal")
    private Sucursal sucursal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_promocion")
    private Promocion promocion;
}
