package com.sprinter.silo.mappers;

import java.util.List;


public interface SiloMapper<E,DTO> {
    DTO toDto(E entity);

    /**
     * To dtos list.
     *
     * @param entities the entities
     * @return the list
     */
    List<DTO> toDtos(List<E> entities);

    /**
     * To entity e.
     *
     * @param dto the dto
     * @return the e
     */
    E toEntity(DTO dto);
}
