package com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.usuario;


import com.fiap.tc2sub.Biblioteca.service.gateway.usuario.EditUsuarioGateway;
import com.fiap.tc2sub.Biblioteca.model.usuario.Usuario;
import com.fiap.tc2sub.Biblioteca.usecase.usuario.EditUsuarioUseCase;

public class EditUsuarioUseCaseImpl implements EditUsuarioUseCase {

    private final EditUsuarioGateway editUsuarioGateway;

    public EditUsuarioUseCaseImpl(EditUsuarioGateway editUsuarioGateway) {
        this.editUsuarioGateway = editUsuarioGateway;
    }

    @Override
    public Usuario editUsuario(String email, Usuario usuario) throws Exception {
        return editUsuarioGateway.edit(Usuario.validaEmailUsuario(email), usuario);
    }
}
