package com.sprinter.silo.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class ArticuloDto implements Serializable {
    private int id;
    private String ean;
    private String nombre;
    private double importe;
}
