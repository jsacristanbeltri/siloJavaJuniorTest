package com.sprinter.silo.mappers;

import com.sprinter.silo.dtos.ArticuloDto;
import com.sprinter.silo.models.Articulo;

import java.util.List;


public interface SiloMapper {
   ArticuloDto toDto (Articulo articulo);
   Articulo toEntity(ArticuloDto dto);
   List<ArticuloDto> toDtos (List<Articulo> entities);
}
