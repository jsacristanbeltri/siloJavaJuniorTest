package com.sprinter.silo.dtos;

import com.sprinter.silo.models.Articulo;
import com.sprinter.silo.models.Pedido;
import com.sprinter.silo.models.PedidoLinea;
import lombok.Data;

import java.io.Serializable;

@Data
public class PedidoLineaDto implements Serializable {
    private int id;
    private PedidoDto pedido;
    private ArticuloDto articulo;
    private int cantidad;
    private int total;
}
