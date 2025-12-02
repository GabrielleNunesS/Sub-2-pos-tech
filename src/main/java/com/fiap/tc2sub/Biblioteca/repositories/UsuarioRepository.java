package com.fiap.tc2sub.Biblioteca.repositories;

import com.fiap.tc2sub.Biblioteca.entity.EntityUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <EntityUsuario, String> {
    public Optional<EntityUsuario> findByEmail(String email);

    public Optional<EntityUsuario> findByNome(String nome);
}
