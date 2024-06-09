package com.example.JPAElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//@MappedSuperclass
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Persona extends Base implements Serializable {

    @Column(name = "nombre")
    protected String nombre;

    @Column(name = "apellido")
    protected String apellido;

    @Column(name = "fecha_nacimiento")
    protected Date fechaNacimiento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_imagen")
    protected Imagen imagen;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_usuario")
    protected Usuario usuario;

    // Relación One-to-Many unidireccional con Email
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id")
    protected List<Email> emails;

    // Relación One-to-Many unidireccional con historicoRol
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id")
    protected List<HistoricoRol> historicoRoles;

    // Relación One-to-Many unidireccional con telefono
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id")
    protected List<Telefono> telefonos;
}
