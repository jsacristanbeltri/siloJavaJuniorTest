package com.sprinter.silo.mappers;

import com.sprinter.silo.dtos.ArticuloDto;
import com.sprinter.silo.models.Articulo;

import java.util.List;


public interface SiloMapper<E,DTO> {
   DTO toDto (E entity);
   E toEntity(DTO dto);
   List<DTO> toDtos (List<E> entities);
}
