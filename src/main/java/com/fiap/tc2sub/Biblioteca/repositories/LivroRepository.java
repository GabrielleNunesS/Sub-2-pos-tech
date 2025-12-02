package com.fiap.tc2sub.Biblioteca.repositories;

import com.fiap.tc2sub.Biblioteca.entity.EntityLivro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends JpaRepository <EntityLivro, String> {
    Optional<EntityLivro> findByIsbn(String isbn);
    Page<EntityLivro> findByAutorContainingIgnoreCase(String autor, Pageable pageable);
    Page<EntityLivro> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);
    Page<EntityLivro> findByEditoraContainingIgnoreCase(String editora, Pageable pageable);
}
