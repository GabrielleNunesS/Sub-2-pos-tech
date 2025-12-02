package com.fiap.tc2sub.Biblioteca.mappers;

import com.fiap.tc2sub.Biblioteca.dto.usuario.request.UsuarioPostRequestDTO;
import com.fiap.tc2sub.Biblioteca.entity.EntityUsuario;
import com.fiap.tc2sub.Biblioteca.model.usuario.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    EntityUsuario usuarioToEntityUsuario(Usuario usuario);
    Usuario entityUsuarioToUsuario(EntityUsuario entityUsuario);

    Usuario usuarioPostRequestDTOToUsuario(UsuarioPostRequestDTO usuarioPostReqBody);

}

