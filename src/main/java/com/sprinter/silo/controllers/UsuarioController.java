package com.sprinter.silo.controllers;

import com.sprinter.silo.service.ArticuloServiceImpl;
import com.sprinter.silo.service.UsuarioServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private ModelMapper modelMapper;

}
