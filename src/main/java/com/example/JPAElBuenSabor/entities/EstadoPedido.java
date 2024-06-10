package com.example.JPAElBuenSabor.entities;

import com.example.JPAElBuenSabor.entities.enums.Estado;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class EstadoPedido extends Base{

    private Integer minutos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    private Estado estado;
}
