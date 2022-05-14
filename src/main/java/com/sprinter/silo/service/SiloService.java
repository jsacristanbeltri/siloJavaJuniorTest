package com.sprinter.silo.service;

import com.sprinter.silo.dtos.ArticuloDto;

import java.util.List;

public interface SiloService<DTO> {
    List<DTO> findAll();
    DTO findById(int id);
    DTO create(DTO orderDto);
    DTO update(int id, DTO orderDto);
    void delete(int id);
}
