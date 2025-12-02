package com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.usuario;


import com.fiap.tc2sub.Biblioteca.service.gateway.usuario.DeleteUsuarioGateway;
import com.fiap.tc2sub.Biblioteca.model.usuario.Usuario;
import com.fiap.tc2sub.Biblioteca.usecase.usuario.DeleteUsuarioUseCase;

public class DeleteUsuarioUseCaseImpl implements DeleteUsuarioUseCase {
    private final DeleteUsuarioGateway deleteUsuarioGateway;

    public DeleteUsuarioUseCaseImpl(DeleteUsuarioGateway deleteUsuarioGateway) {
        this.deleteUsuarioGateway = deleteUsuarioGateway;
    }

    @Override
    public void delete(String email) {
        deleteUsuarioGateway.delete(Usuario.validaEmailUsuario(email));
    }
}
