package com.sprinter.silo.controllers;

import com.sprinter.silo.dtos.PedidoLineaDto;
import com.sprinter.silo.models.Pedido;
import com.sprinter.silo.service.PedidoLineaService;
import com.sprinter.silo.service.PedidoService;
import com.sprinter.silo.service.SiloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidolinea")
public class PedidoLineaController extends AbstractSiloController<PedidoLineaDto> {

    @Autowired
    public PedidoLineaController(PedidoLineaService service) {
        super(service);
    }
}
