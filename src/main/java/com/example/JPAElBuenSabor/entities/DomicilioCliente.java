
package com.example.JPAElBuenSabor.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class DomicilioCliente extends Base{

    private Boolean estaActivo;
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="domicilio_id")
    private Domicilio domicilio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
}
