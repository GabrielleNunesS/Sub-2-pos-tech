package com.fiap.tc2sub.Biblioteca.usecase.usuario;


import com.fiap.tc2sub.Biblioteca.model.usuario.Usuario;

public interface EditUsuarioUseCase {
    Usuario editUsuario(String email, Usuario usuario) throws Exception ;
}
