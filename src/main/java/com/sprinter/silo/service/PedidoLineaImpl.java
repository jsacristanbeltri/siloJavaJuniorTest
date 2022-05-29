package com.sprinter.silo.service;

import com.sprinter.silo.dtos.PedidoDto;
import com.sprinter.silo.dtos.PedidoLineaDto;
import com.sprinter.silo.mappers.PedidoLineaMapper;
import com.sprinter.silo.mappers.SiloMapper;
import com.sprinter.silo.models.Pedido;
import com.sprinter.silo.models.PedidoLinea;
import com.sprinter.silo.repository.PedidoLineaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoLineaImpl extends AbstractSiloService<PedidoLinea, PedidoLineaDto> implements PedidoLineaService {

    public PedidoLineaImpl(PedidoLineaRepository repository, PedidoLineaMapper mapper) {
        super(repository, mapper);
    }


    @Override
    public PedidoLineaDto create(PedidoLineaDto orderDto) {
        return mapper.toDto(repository.save(mapper.toEntity(orderDto)));
    }

    @Override
    public PedidoLineaDto update(int id, PedidoLineaDto orderDto) {
        PedidoLinea pedidoLinea = get(id);
        pedidoLinea.setId(id);

        return mapper.toDto(repository.save(mapper.toEntity(orderDto)));
    }
}

