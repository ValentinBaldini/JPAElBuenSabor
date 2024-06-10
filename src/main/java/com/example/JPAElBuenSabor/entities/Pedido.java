package com.example.JPAElBuenSabor.entities;

import com.example.JPAElBuenSabor.entities.enums.TipoEnvio;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Pedido extends Base {

    private String horaEstimadaFinalizacion;

    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    private Date fechaPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sucursal_id")
    private Sucursal sucursal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="domicilio_cliente_id")
    private DomicilioCliente domicilioCliente;
}
