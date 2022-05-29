package com.sprinter.silo.dtos;

import com.sprinter.silo.models.Pedido;
import lombok.*;

import java.io.Serializable;

@Data
public class ArticuloDto implements Serializable {
    private int id;
    private String ean;
    private String nombre;
    private double importe;
    private String color;
    private String talla;

    public ArticuloDto(int id, String ean, String nombre, double importe, String color, String talla) {
        this.id = id;
        this.ean = ean;
        this.nombre = nombre;
        this.importe = importe;
        this.color = color;
        this.talla = talla;
    }

    public ArticuloDto (){
    }
}
