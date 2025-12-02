package com.fiap.tc2sub.Biblioteca.service.usuario;


import com.fiap.tc2sub.Biblioteca.entity.EntityUsuario;
import com.fiap.tc2sub.Biblioteca.service.gateway.usuario.EditUsuarioGateway;
import com.fiap.tc2sub.Biblioteca.mappers.UsuarioMapper;
import com.fiap.tc2sub.Biblioteca.model.usuario.Usuario;
import com.fiap.tc2sub.Biblioteca.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EditUsuarioGatewayImpl implements EditUsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario edit(String email, Usuario usuario) {
        EntityUsuario entityUsuario = usuarioRepository.findByEmail(email)
                .map(existingUsuario -> {
                    existingUsuario.setNome(usuario.getNome());
                    existingUsuario.setEmail(usuario.getEmail());
                    existingUsuario.setTelefone(usuario.getTelefone());
                    return usuarioRepository.save(existingUsuario);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não localizado"));

        return UsuarioMapper.INSTANCE.entityUsuarioToUsuario(entityUsuario);
    }
}
