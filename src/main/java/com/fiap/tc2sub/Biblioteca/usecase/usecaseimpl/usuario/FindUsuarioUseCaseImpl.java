package com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.usuario;



import com.fiap.tc2sub.Biblioteca.service.gateway.usuario.FindUsuarioGateway;
import com.fiap.tc2sub.Biblioteca.model.usuario.Usuario;
import com.fiap.tc2sub.Biblioteca.usecase.usuario.FindUsuarioUseCase;

import java.util.Optional;

public class FindUsuarioUseCaseImpl implements FindUsuarioUseCase {
    private final FindUsuarioGateway findUsuarioGateway;

    public FindUsuarioUseCaseImpl(FindUsuarioGateway findUsuarioGateway) {
        this.findUsuarioGateway = findUsuarioGateway;
    }

    @Override
    public Optional<Usuario> findUsuario(String email) throws Exception {
        return findUsuarioGateway.findPorEmail(Usuario.validaEmailUsuario(email));
    }

    @Override
    public Optional<Usuario> findUsuarioNome(String nome) throws Exception {
        return findUsuarioGateway.findPorEmail(Usuario.validaNomeUsuario(nome));
    }
}
