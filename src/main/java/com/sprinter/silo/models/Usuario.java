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
    private int id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private String telefono;
}
