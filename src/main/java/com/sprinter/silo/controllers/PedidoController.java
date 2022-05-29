package com.sprinter.silo.controllers;

import com.sprinter.silo.dtos.PedidoDto;
import com.sprinter.silo.service.PedidoService;
import com.sprinter.silo.service.SiloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController extends AbstractSiloController<PedidoDto>{
    public PedidoController(PedidoService pedidoService) {
        super(pedidoService);
    }
}
