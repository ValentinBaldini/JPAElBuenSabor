package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Sucursal extends Base{

    private String nombre;
    private Boolean esCasaMatriz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="empresa_id")
    private Empresa empresa;

    @OneToOne
    private Domicilio domicilio;
/*
    @ManyToMany
    //SE AGREGA EL JOIN TABLE PARA QUE JPA CREE LA TABLA INTERMEDIA EN UNA RELACION MANY TO MANY
    @JoinTable(name = "sucursal_categoria",
            joinColumns = @JoinColumn(name = "sucursal_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    //SE AGREGA EL BUILDER.DEFAULT PARA QUE BUILDER NO SOBREESCRIBA LA INICIALIZACION DE LA LISTA
    @Builder.Default
    private Set<Categoria> categorias = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinTable(name = "sucursal_promocion",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "sucursal_id"))
    @Builder.Default
    private Set<Promocion> promociones = new HashSet<>();

    @OneToMany(mappedBy = "sucursal",cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();

    @OneToMany(mappedBy = "sucursal",cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Empleado> empleados = new HashSet<>();*/
}
