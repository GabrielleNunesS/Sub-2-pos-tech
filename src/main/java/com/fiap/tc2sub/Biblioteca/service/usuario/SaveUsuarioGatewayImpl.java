package com.fiap.tc2sub.Biblioteca.service.usuario;


import com.fiap.tc2sub.Biblioteca.entity.EntityUsuario;
import com.fiap.tc2sub.Biblioteca.mappers.UsuarioMapper;
import com.fiap.tc2sub.Biblioteca.model.usuario.Usuario;
import com.fiap.tc2sub.Biblioteca.repositories.UsuarioRepository;
import com.fiap.tc2sub.Biblioteca.service.gateway.usuario.SaveUsuarioGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SaveUsuarioGatewayImpl implements SaveUsuarioGateway {
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        EntityUsuario saved = usuarioRepository.save(UsuarioMapper.INSTANCE.usuarioToEntityUsuario(usuario));
        return  UsuarioMapper.INSTANCE.entityUsuarioToUsuario(saved);
    }
}
