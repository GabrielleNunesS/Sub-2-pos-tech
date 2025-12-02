package com.fiap.tc2sub.Biblioteca.repositories;

import com.fiap.tc2sub.Biblioteca.entity.EntityEmprestimo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmprestimoRepository extends JpaRepository<EntityEmprestimo, UUID> {
    Optional<EntityEmprestimo> findByIdUsuarioAndIdLivroAndDataRealDevolucaoIsNull(String idUsuario, String idLivro);
    List<EntityEmprestimo> findAllByIdLivroAndDataRealDevolucaoIsNull(String idLivro);
    Page<EntityEmprestimo> findByIdUsuario(String idUsuario, Pageable pageable);
}
