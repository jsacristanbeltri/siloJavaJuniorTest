package com.sprinter.silo.service;

import com.sprinter.silo.dtos.ArticuloDto;
import com.sprinter.silo.dtos.UsuarioDto;
import com.sprinter.silo.models.Usuario;
import com.sprinter.silo.repository.ArticuloRepository;
import com.sprinter.silo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private final UsuarioRepository usuarioRepository;


    @Override
    public List<UsuarioDto> findAll() {
        return null;
    }

    @Override
    public UsuarioDto findById(int id) {
        return null;
    }

    @Override
    public UsuarioDto create(UsuarioDto orderDto) {
        return null;
    }


    @Override
    public UsuarioDto update(int id, UsuarioDto orderDto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}

