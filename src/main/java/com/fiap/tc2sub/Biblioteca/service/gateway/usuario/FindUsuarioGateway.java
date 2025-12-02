package com.fiap.tc2sub.Biblioteca.service.gateway.usuario;

import com.fiap.tc2sub.Biblioteca.model.usuario.Usuario;

import java.util.Optional;

public interface FindUsuarioGateway {
    Optional<Usuario> findPorEmail(String email);

    Optional<Usuario> findPorNome(String nome);
}
