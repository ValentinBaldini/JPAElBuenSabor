package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.servlet.tags.ArgumentTag;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class PromocionDetalle extends Base{

    private int cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promocion_id")
    private Promocion promocion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;

}
