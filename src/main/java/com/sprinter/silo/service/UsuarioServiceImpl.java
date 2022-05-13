package com.sprinter.silo.service;

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
    public Usuario addUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return null;
    }

    @Override
    public Usuario getUsuarioById(int id) {
        return null;
    }

    @Override
    public Usuario updateUsuario(int id, Usuario usuario) {
        return null;
    }

    @Override
    public void deleteUsuario(int id) {

    }
}
