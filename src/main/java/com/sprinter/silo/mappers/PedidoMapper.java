package com.sprinter.silo.mappers;

import com.sprinter.silo.dtos.ArticuloDto;
import com.sprinter.silo.dtos.PedidoDto;
import com.sprinter.silo.dtos.PedidoLineaDto;
import com.sprinter.silo.models.Pedido;
import com.sprinter.silo.models.PedidoLinea;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Mapper(componentModel = "spring", uses = PedidoLinea.class)
public abstract class PedidoMapper implements SiloMapper<Pedido, PedidoDto>{

    @Autowired
    protected PedidoLineaMapper pedidoLineaMapper;

    //public abstract PedidoDto toDto (Pedido pedido);
    //public abstract Pedido toEntity (PedidoDto pedidoDto);
    public abstract List<PedidoDto> toDtos (List<Pedido> pedidos);


    public PedidoDto toDto (Pedido pedido){

        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setId(pedido.getId());
        log.info("pedido 0: linea 0: cantidad: " + pedido.getLineasPedido().get(0).getCantidad());
        log.info("pedido 0: linea 0: id: " + pedido.getLineasPedido().get(0).getArticulo().getId());
        log.info("pedido 0: linea 0: nombre: " + pedido.getLineasPedido().get(0).getArticulo().getNombre());
        pedidoDto.setLineasPedido(convertListaPedidoToListDtos(pedido.getLineasPedido()));

        return pedidoDto;
    }

    private List<PedidoLineaDto> convertListaPedidoToListDtos(List<PedidoLinea> lineasPedido) {
        if(lineasPedido == null)
            return null;

        List<PedidoLineaDto> pedidosLineaDto = new ArrayList<>();
        for (int i =0;i<lineasPedido.size();i++){
            pedidosLineaDto.add(pedidoLineaMapper.toDto(lineasPedido.get(i)));
        }
        return pedidosLineaDto;
    }

    public Pedido toEntity (PedidoDto pedidoDto){
        Pedido pedido = new Pedido();
        log.info("mapper pedido, toEntity: pedidoDto 0, linea 0, articulo id: " + pedidoDto.getLineasPedido().get(0).getArticulo().getId());
        pedido.setId(pedidoDto.getId());
        log.info("mapper pedido, toEntity: pedido 0, linea 0, articulo id: " + pedido.getLineasPedido().get(0).getArticulo().getId());
        pedido.setLineasPedido(convertListaPedidoDtosToListEntity(pedidoDto.getLineasPedido()));
        return pedido;
    }

    protected List<PedidoLinea> convertListaPedidoDtosToListEntity(List<PedidoLineaDto> list) {
        if ( list == null ) {
            return null;
        }

        List<PedidoLinea> list1 = new ArrayList<PedidoLinea>( list.size() );
        for(int i=0;i<list.size();i++){
            list1.add(pedidoLineaMapper.toEntity(list.get(i)));
        }

        return list1;
    }

    /*public List<PedidoDto> toDtos (List<Pedido> pedidos){
        if(pedidos==null)
            return null;
        PedidoDto nuevoPedido = new PedidoDto();
        List<PedidoDto> pedidoDtos = new ArrayList<>();
        for(int i=0;i< pedidos.size();i++){
                nuevoPedido.setId(pedidos.get(i).getId());
                if(pedidos.get(i).getLineasPedido().size()==0){
                     nuevoPedido.setLineasPedido(null);
                }
                else
                {
                    nuevoPedido.setLineasPedido(pedidoLineaMapper.toDtos(pedidos.get(i).getLineasPedido()));
                    pedidoDtos.add(nuevoPedido);
                }

        }
        return pedidoDtos;
    }*/




    /*public PedidoDto converToDto (Pedido pedido){
        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setId(pedido.getId());
        log.info("pedido 0: linea 0: cantidad: " + pedido.getLineasPedido().get(0).getCantidad());
        log.info("pedido 0: linea 0: id: " + pedido.getLineasPedido().get(0).getArticulo().getId());
        log.info("pedido 0: linea 0: nombre: " + pedido.getLineasPedido().get(0).getArticulo().getNombre());
        pedidoDto.setLineasPedido(convertListaPedidoToListDtos(pedido.getLineasPedido()));

        return pedidoDto;
    }*/

}
