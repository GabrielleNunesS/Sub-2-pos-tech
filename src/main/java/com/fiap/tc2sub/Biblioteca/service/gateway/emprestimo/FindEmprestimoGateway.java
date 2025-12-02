package com.fiap.tc2sub.Biblioteca.service.gateway.emprestimo;

import com.fiap.tc2sub.Biblioteca.model.emprestimo.Emprestimo;
import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import com.fiap.tc2sub.Biblioteca.model.livro.Page;

import java.time.LocalDate;
import java.util.Optional;

public interface FindEmprestimoGateway {
    Optional<Emprestimo> findVerificaEmprestimo(String idUsuario, String isbn);
    boolean findVerificaLivroDisponivel(String isbn) throws Exception;
    boolean findVerificaLivroEmprestado(String idUsuario, String idLivro);
    Optional<Livro> findVerificaLivro(String idLivro) throws Exception;
    Optional<String> findVerificaUsuario(String idUsuario) throws Exception;
}
