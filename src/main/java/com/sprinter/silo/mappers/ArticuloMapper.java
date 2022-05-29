package com.sprinter.silo.mappers;

import com.sprinter.silo.dtos.ArticuloDto;
import com.sprinter.silo.models.Articulo;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;

import java.util.List;

@Slf4j
@Mapper(componentModel = "spring")
public abstract class ArticuloMapper implements SiloMapper<Articulo,ArticuloDto>{

    //public abstract ArticuloDto toDto(Articulo articulo);
    //public abstract Articulo toEntity(ArticuloDto dto);
    public abstract List<ArticuloDto> toDtos(List<Articulo> entities);

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
}
