package com.fiap.tc2sub.Biblioteca.service.usuario;


import com.fiap.tc2sub.Biblioteca.entity.EntityUsuario;
import com.fiap.tc2sub.Biblioteca.service.gateway.usuario.FindUsuarioGateway;
import com.fiap.tc2sub.Biblioteca.mappers.UsuarioMapper;
import com.fiap.tc2sub.Biblioteca.model.usuario.Usuario;
import com.fiap.tc2sub.Biblioteca.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class FindUsuarioGatewayImpl implements FindUsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> findPorEmail(String email){
        EntityUsuario usuario = usuarioRepository.findByEmail(email).isPresent()
                ? usuarioRepository.findByEmail(email).get()
                : null;
        return Optional.ofNullable(UsuarioMapper.INSTANCE.entityUsuarioToUsuario(usuario));
    }

    @Override
    public Optional<Usuario> findPorNome(String nome){
        EntityUsuario usuario = usuarioRepository.findByNome(nome).isPresent()
                ? usuarioRepository.findByNome(nome).get()
                : null;
        return Optional.ofNullable(UsuarioMapper.INSTANCE.entityUsuarioToUsuario(usuario));
    }
}
