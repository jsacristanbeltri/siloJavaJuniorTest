package com.sprinter.silo.dtos;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class ArticuloDto implements Serializable {
    private int id;
    private String ean;
    private String nombre;
    private double importe;
    private String color;
    private String talla;
}
