package com.sprinter.silo.dtos;

import com.sprinter.silo.models.Articulo;
import com.sprinter.silo.models.PedidoLinea;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Data
public class PedidoDto implements Serializable {
    private int id;
    private List<PedidoLineaDto> lineasPedido;
}
