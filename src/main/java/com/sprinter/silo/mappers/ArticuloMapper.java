package com.sprinter.silo.mappers;

import com.sprinter.silo.dtos.ArticuloDto;
import com.sprinter.silo.models.Articulo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ArticuloMapper implements SiloMapper<Articulo, ArticuloDto> {
    public abstract ArticuloDto toDto (Articulo entity);
    public abstract Articulo toEntity (ArticuloDto dto);
    public abstract List<ArticuloDto> toDtos (List<Articulo> entities);
}
