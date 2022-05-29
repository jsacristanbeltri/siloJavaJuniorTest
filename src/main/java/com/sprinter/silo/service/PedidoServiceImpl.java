package com.sprinter.silo.service;

import com.sprinter.silo.dtos.PedidoDto;
import com.sprinter.silo.mappers.PedidoMapper;
import com.sprinter.silo.mappers.SiloMapper;
import com.sprinter.silo.models.Articulo;
import com.sprinter.silo.models.Pedido;
import com.sprinter.silo.repository.PedidoRepository;
import com.sprinter.silo.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PedidoServiceImpl extends AbstractSiloService<Pedido, PedidoDto> implements PedidoService {

    @Autowired
    public PedidoServiceImpl(PedidoRepository repository, PedidoMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public PedidoDto create(PedidoDto orderDto) {
        log.info("Orden nº: "+orderDto.getId());
        log.info("DTO: Lineas totales pedido: " + orderDto.getLineasPedido().size());
        log.info("DTO: linea 0, id articulo: " + orderDto.getLineasPedido().get(0).getArticulo().getId());
        log.info("DTO: linea 0, nombre articulo: " + orderDto.getLineasPedido().get(0).getArticulo().getNombre());
        Pedido pedido = mapper.toEntity(orderDto);
        log.info("Lineas totales pedido: " + pedido.getLineasPedido().size());
        log.info("linea 0, id articulo: " + pedido.getLineasPedido().get(0).getArticulo().getId());
        log.info("linea 0, nombre articulo: " + pedido.getLineasPedido().get(0).getArticulo().getNombre());
        repository.save(pedido);
        return mapper.toDto(pedido);
    }

    @Override
    public PedidoDto update(int id, PedidoDto orderDto) {
        Pedido pedido = get(id);
        pedido.setId(id);

        return mapper.toDto(repository.save(mapper.toEntity(orderDto)));
    }
}
