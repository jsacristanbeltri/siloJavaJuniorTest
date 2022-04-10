package com.sprinter.silo.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Entidad encargada de manejar los objetos de tipo
 * artículo.
 */

@ToString
@EqualsAndHashCode
@Entity
public class Articulo {

    @Getter @Setter @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Getter @Setter
    @Column (name = "ean")
    private String ean;

    @Getter @Setter
    @Column (name = "nombre")
    private String nombre;

    @Getter @Setter
    @Column (name = "importe")
    private double importe;

    @Getter @Setter
    @Column (name = "talla")
    private String talla;

    @Getter @Setter
    @Column (name = "color")
    private String color;

    /**
     * Constructor de la clase Articulo
     */
    public Articulo (){
        this.ean = "";
        this.nombre ="";
        this.importe = 0.0;
        this.talla = "";
        this.color = "";
    }

    /**
     * Constructor secundario de la clase Articulo. Nos permite crear un articulo con
     * todos sus parametros.
     * @param id identificacion interna del artículo
     * @param ean matrícula del artículo
     * @param nombre nombre del artículo
     * @param importe importe del artículo
     * @param talla talla del artículo
     * @param color color del artículo
     */
    public Articulo (int id,String ean,String nombre, double importe, String talla, String color){
        this.id = id;
        this.ean = ean;
        this.nombre = nombre;
        this.importe = importe;
        this.talla = talla;
        this.color = color;
    }

}
