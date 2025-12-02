package com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.usuario;


import com.fiap.tc2sub.Biblioteca.service.gateway.usuario.SaveUsuarioGateway;
import com.fiap.tc2sub.Biblioteca.model.usuario.Usuario;
import com.fiap.tc2sub.Biblioteca.usecase.usuario.FindUsuarioUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.usuario.SaveUsuarioUseCase;

public class SaveUsuarioUseCaseImpl implements SaveUsuarioUseCase {

    private final SaveUsuarioGateway saveUsuarioGateway;
    private final FindUsuarioUseCase findUsuarioUseCase;

    public SaveUsuarioUseCaseImpl(SaveUsuarioGateway saveUsuarioGateway, FindUsuarioUseCase findUsuarioUseCase) {
        this.saveUsuarioGateway = saveUsuarioGateway;
        this.findUsuarioUseCase = findUsuarioUseCase;
    }

    @Override
    public Usuario save(Usuario usuario) throws Exception {
        if (findUsuarioUseCase.findUsuario(usuario.getEmail()).isPresent()) {
            throw new Exception("Usuário já cadastrado");
        }
        return saveUsuarioGateway.save(usuario);
    }
}
