package com.sprinter.silo.controllers;

import com.sprinter.silo.dtos.ArticuloDto;
import com.sprinter.silo.models.Articulo;
import com.sprinter.silo.service.ArticuloService;
import com.sprinter.silo.service.ArticuloServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/articulo")
public class ArticuloController extends AbstractSiloController {

    @Autowired
    public ArticuloController(ArticuloService service) {
        super(service);
    }
}



