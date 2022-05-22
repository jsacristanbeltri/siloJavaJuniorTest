package com.sprinter.silo.mappers;

import com.sprinter.silo.dtos.ArticuloDto;
import com.sprinter.silo.models.Articulo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ArticuloMapper implements SiloMapper<Articulo,ArticuloDto>{
    public ArticuloDto toDto(Articulo articulo){
        ArticuloDto articuloDto = new ArticuloDto();
        articuloDto.setId(articulo.getId());
        articuloDto.setEan(articulo.getEan());
        articuloDto.setNombre(articulo.getNombre());
        articuloDto.setImporte(articulo.getImporte());
        articuloDto.setColor(articulo.getColor());
        articuloDto.setTalla(articulo.getTalla());
        return articuloDto;
    }
    public Articulo toEntity(ArticuloDto dto){
        Articulo articulo = new Articulo();
        articulo.setId(dto.getId());
        articulo.setEan(dto.getEan());
        articulo.setNombre(dto.getNombre());
        articulo.setColor(dto.getColor());
        articulo.setTalla(dto.getTalla());

        return articulo;
    }
    public abstract List<ArticuloDto> toDtos(List<Articulo> entities);
}
