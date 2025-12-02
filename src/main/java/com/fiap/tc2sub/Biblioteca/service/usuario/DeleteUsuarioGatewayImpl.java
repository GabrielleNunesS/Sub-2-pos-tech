package com.fiap.tc2sub.Biblioteca.service.usuario;

import com.fiap.tc2sub.Biblioteca.service.gateway.usuario.DeleteUsuarioGateway;
import com.fiap.tc2sub.Biblioteca.model.usuario.Usuario;
import com.fiap.tc2sub.Biblioteca.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteUsuarioGatewayImpl implements DeleteUsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    @Override
    public void delete(String email) {
        usuarioRepository.delete(usuarioRepository.findByEmail(Usuario.validaEmailUsuario(email)).orElseThrow(() -> new RuntimeException("Usuario não encontrado")));
    }
}
