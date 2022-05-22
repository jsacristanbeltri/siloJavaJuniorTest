package com.sprinter.silo.service;

import com.sprinter.silo.dtos.ArticuloDto;
import com.sprinter.silo.mappers.SiloMapper;
import com.sprinter.silo.models.Articulo;
import com.sprinter.silo.models.SiloEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
public class AbstractSiloService <E extends SiloEntity, DTO> {
    protected final JpaRepository<E,Integer> repository;
    protected final SiloMapper<E,DTO> mapper;

    public AbstractSiloService(JpaRepository<E, Integer> repository, SiloMapper<E, DTO> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    protected E get(int id) {
        Optional<E> articuloResponse = repository.findById(id);
        return articuloResponse.get();
    }


    public List<DTO> findAll() {
        //log.debug("Finding all pageable");
        //final Page<E> page = repository.findAll(pageable);
        //return new PageImpl<>(mapper.toDtos(page.getContent()), page.getPageable(), page.getTotalElements());
        List<E> all = repository.findAll();
        return  mapper.toDtos(all);
    }

    /**
     * Find dto.
     *
     * @param id the id
     * @return the dto
     */
    public DTO findById(int id) {
        log.debug("Finding {}", id);
        return mapper.toDto(get(id));
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(int id) {
        log.debug("Deleting {}", id);
        repository.delete(get(id));
    }

}
