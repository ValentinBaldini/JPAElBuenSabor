package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class ArticuloInsumo extends Articulo{

    private Integer stockMaximo;
    private Integer stockMinimo;
    private Boolean esParaElaborar;

}
