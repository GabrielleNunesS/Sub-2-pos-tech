package com.fiap.tc2sub.Biblioteca.usecase.usuario;


import com.fiap.tc2sub.Biblioteca.model.usuario.Usuario;

public interface SaveUsuarioUseCase {
    Usuario save(Usuario usuario) throws Exception;
}
