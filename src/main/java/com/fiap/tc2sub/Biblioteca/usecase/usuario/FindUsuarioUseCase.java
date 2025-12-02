package com.fiap.tc2sub.Biblioteca.usecase.usuario;


import com.fiap.tc2sub.Biblioteca.model.usuario.Usuario;

import java.util.Optional;

public interface FindUsuarioUseCase {
    Optional<Usuario> findUsuario(String email) throws Exception;

    Optional<Usuario> findUsuarioNome(String nome) throws Exception;
}
