package com.sprinter.silo.mappers;

import com.sprinter.silo.dtos.UsuarioDto;
import com.sprinter.silo.models.Usuario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper implements SiloMapper<Usuario,UsuarioDto>{

    public abstract UsuarioDto toDto (Usuario usuario);
    public abstract Usuario toEntity (UsuarioDto usuarioDto);
    public abstract List<UsuarioDto> toDtos (List<Usuario> usuarios);

    /*public UsuarioDto toDto (Usuario usuario){
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setDni(usuario.getDni());

        return usuarioDto;
    }
    public Usuario toEntity (UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDto.getId());
        usuario.setDni(usuarioDto.getDni());
        return usuario;
    }*/

}
