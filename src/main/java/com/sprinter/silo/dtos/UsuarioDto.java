package com.sprinter.silo.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data
public class UsuarioDto implements Serializable {
    private int id;
    private String dni;
}
