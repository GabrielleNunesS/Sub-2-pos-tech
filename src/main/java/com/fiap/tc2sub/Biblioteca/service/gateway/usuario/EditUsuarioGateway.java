package com.fiap.tc2sub.Biblioteca.service.gateway.usuario;

import com.fiap.tc2sub.Biblioteca.model.usuario.Usuario;

public interface EditUsuarioGateway {
    Usuario edit(String email, Usuario usuario);
}
