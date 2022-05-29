package com.sprinter.silo.models;

import lombok.*;

import javax.persistence.*;


@Entity
@RequiredArgsConstructor
@Data
@Table(name="usuarios")
public class Usuario implements SiloEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "dni")
    private String dni;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;
}
