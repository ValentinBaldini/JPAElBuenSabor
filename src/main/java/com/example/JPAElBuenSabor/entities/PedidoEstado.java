package com.example.JPAElBuenSabor.entities;

import com.example.JPAElBuenSabor.entities.enums.Estado;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.sql.ast.tree.expression.Collation;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class PedidoEstado extends Base{

    private int minutos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    private Estado estado;
}
