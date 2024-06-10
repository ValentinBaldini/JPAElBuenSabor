package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.sql.ast.tree.expression.Collation;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pedidoEstado")
public class PedidoEstado extends Base{

    @Column(name = "minutos")
    private int minutos;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_pedido")
    private Pedido pedido;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_estado")
    private Estado estado;
}
