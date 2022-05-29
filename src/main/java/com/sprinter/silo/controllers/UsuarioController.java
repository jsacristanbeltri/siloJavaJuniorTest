package com.sprinter.silo.controllers;

import com.sprinter.silo.dtos.UsuarioDto;
import com.sprinter.silo.service.ArticuloService;
import com.sprinter.silo.service.ArticuloServiceImpl;
import com.sprinter.silo.service.UsuarioService;
import com.sprinter.silo.service.UsuarioServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends AbstractSiloController<UsuarioDto> {

    @Autowired
    public UsuarioController(UsuarioService service) {
        super(service);
    };


}
