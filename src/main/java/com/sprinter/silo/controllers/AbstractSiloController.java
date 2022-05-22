package com.sprinter.silo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprinter.silo.dtos.ArticuloDto;
import com.sprinter.silo.service.SiloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Slf4j
public class AbstractSiloController<DTO> {
    protected final SiloService<DTO> siloService;

    public AbstractSiloController(SiloService<DTO> siloService) {
        this.siloService = siloService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<DTO> findAll (){
        return siloService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    /*public ResponseEntity<DTO> find (final @PathVariable int id){
        return ResponseEntity.ok(siloService.findById(id));
    }*/
    public DTO find (final @PathVariable int id){
        return siloService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public DTO create(final @RequestBody @Valid DTO dto){
        return siloService.create(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DTO update(final @PathVariable int id, final @RequestBody @Valid DTO dto){
        return siloService.update(id,dto);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(final @PathVariable int id){
        siloService.delete(id);
    }
}
