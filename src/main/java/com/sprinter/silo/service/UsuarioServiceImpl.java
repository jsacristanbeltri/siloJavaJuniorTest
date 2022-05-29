package com.sprinter.silo.service;

import com.sprinter.silo.dtos.ArticuloDto;
import com.sprinter.silo.dtos.UsuarioDto;
import com.sprinter.silo.mappers.SiloMapper;
import com.sprinter.silo.mappers.UsuarioMapper;
import com.sprinter.silo.models.Usuario;
import com.sprinter.silo.repository.ArticuloRepository;
import com.sprinter.silo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl extends AbstractSiloService<Usuario,UsuarioDto> implements UsuarioService{


    public UsuarioServiceImpl(UsuarioRepository repository, UsuarioMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public UsuarioDto create(UsuarioDto orderDto) {

        return mapper.toDto(repository.save(mapper.toEntity(orderDto)));
    }

    @Override
    public UsuarioDto update(int id, UsuarioDto orderDto) {
        Usuario usuarioDBO = get(id);
        usuarioDBO.setId(id);

        return mapper.toDto(repository.save(mapper.toEntity(orderDto)));
    }
}

