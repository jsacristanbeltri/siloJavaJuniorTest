package com.sprinter.silo.mappers;

import com.sprinter.silo.dtos.ArticuloDto;
import com.sprinter.silo.models.Articulo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ArticuloMapper implements SiloMapper{
    public ArticuloDto toDto(Articulo articulo){
        ArticuloDto articuloDto = new ArticuloDto();
        articuloDto.setId(articulo.getId());
        articuloDto.setEan(articulo.getEan());
        articuloDto.setNombre(articulo.getNombre());
        articuloDto.setImporte(articulo.getImporte());
        return articuloDto;
    }
    public abstract Articulo toEntity(ArticuloDto dto);
    public abstract List<ArticuloDto> toDtos(List<Articulo> entities);
}
