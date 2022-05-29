package com.sprinter.silo.mappers;

import com.sprinter.silo.dtos.PedidoDto;
import com.sprinter.silo.dtos.PedidoLineaDto;
import com.sprinter.silo.models.Pedido;
import com.sprinter.silo.models.PedidoLinea;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses=Pedido.class)
public abstract class PedidoLineaMapper implements SiloMapper<PedidoLinea,PedidoLineaDto> {

    @Autowired
    private ArticuloMapper articuloMapper;

    @Autowired
    private PedidoMapper pedidoMapper;

    //public abstract PedidoLineaDto toDto(PedidoLinea pedidoLinea);
    //public abstract PedidoLinea toEntity(PedidoLineaDto pedidoLineaDto);
    public abstract List<PedidoLineaDto> toDtos(List<PedidoLinea> pedidoLineas);

    public PedidoLineaDto toDto(PedidoLinea pedidoLinea) {
        PedidoLineaDto pedidoLineaDto = new PedidoLineaDto();
        pedidoLineaDto.setId(pedidoLinea.getId());
        pedidoLineaDto.setArticulo(articuloMapper.toDto(pedidoLinea.getArticulo()));
        pedidoLineaDto.setCantidad(pedidoLinea.getCantidad());
        pedidoLineaDto.setTotal(pedidoLinea.getTotal());
        //pedidoLineaDto.setPedido(pedidoMapper.toDto(pedidoLinea.getPedido()));
        return pedidoLineaDto;
    }

    public PedidoLinea toEntity(PedidoLineaDto pedidoLineaDto) {
        PedidoLinea pedidoLinea = new PedidoLinea();
        pedidoLinea.setId(pedidoLineaDto.getId());
        pedidoLinea.setPedido(pedidoLinea.getPedido());
        pedidoLinea.setArticulo(pedidoLinea.getArticulo());
        pedidoLinea.setCantidad(pedidoLinea.getCantidad());
        pedidoLinea.setTotal(pedidoLinea.getTotal());
        return pedidoLinea;
    }


    /*public PedidoLineaDto converToDto(PedidoLinea pedido) {
        return null;
    }

    public PedidoLinea pedidoToEntity (PedidoLineaDto pedidoDto){
        return null;
    }*/
}
