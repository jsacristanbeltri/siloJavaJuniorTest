package com.sprinter.silo.models;


import lombok.*;

import javax.persistence.*;

/**
 * Entidad encargada de manejar los objetos de tipo
 * artículo.
 */

@Data
@Entity
@RequiredArgsConstructor
@Table(name="articulos")
public class Articulo implements SiloEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column (name = "ean")
    private String ean;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "importe")
    private double importe;

    @Column (name = "talla")
    private String talla;

    @Column (name = "color")
    private String color;

}
