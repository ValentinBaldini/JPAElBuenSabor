package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@SuperBuilder
public class ArticuloInsumo extends Articulo{

    private Integer stockMaximo;
    private Integer stockMinimo;
    private Boolean esParaElaborar;

}
