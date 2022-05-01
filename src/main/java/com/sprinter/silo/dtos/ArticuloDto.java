package com.sprinter.silo.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data
public class ArticuloDto implements Serializable {
    private int id;
    private String ean;
    private String nombre;
    private double importe;
    private String talla;
    private String color;


}
