package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Provincia extends Base{

    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pais_id")
    private Pais pais;

   /* @OneToMany(mappedBy = "provincia", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Localidad> localidades = new HashSet<>();*/

}
