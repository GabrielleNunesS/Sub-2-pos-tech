package com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.emprestimo;


import com.fiap.tc2sub.Biblioteca.model.emprestimo.Emprestimo;
import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import com.fiap.tc2sub.Biblioteca.model.livro.Page;
import com.fiap.tc2sub.Biblioteca.service.gateway.emprestimo.FindEmprestimoGateway;
import com.fiap.tc2sub.Biblioteca.usecase.emprestimo.FindEmprestimoUseCase;

import java.time.LocalDate;
import java.util.Optional;

public class FindEmprestimoUseCaseImpl implements FindEmprestimoUseCase {
    private final FindEmprestimoGateway findEmprestimoGateway;

    public FindEmprestimoUseCaseImpl(FindEmprestimoGateway findEmprestimoGateway) {
        this.findEmprestimoGateway = findEmprestimoGateway;
    }

    @Override
    public Optional<Emprestimo> findVerificaEmprestimo(String idUsuario, String idLivro) {
        return findEmprestimoGateway.findVerificaEmprestimo(idUsuario, idLivro);
    }

    @Override
    public boolean findVerificaLivroDisponivel(String idLivro) throws Exception {
        return findEmprestimoGateway.findVerificaLivroDisponivel(idLivro);
    }

    @Override
    public boolean findVerificaLivroEmprestado(String idUsuario, String idLivro) {
        return findEmprestimoGateway.findVerificaLivroEmprestado(idUsuario, idLivro);
    }

    @Override
    public Optional<Livro> findVerificaLivro(String idLivro) throws Exception {
        return Optional.of(findEmprestimoGateway.findVerificaLivro(idLivro).orElseThrow(() -> new Exception("Livro não encontrado!")));
    }

    @Override
    public Optional<String> findVerificaUsuario(String idUsuario) throws Exception {
        return Optional.of(findEmprestimoGateway.findVerificaUsuario(idUsuario).orElseThrow(() -> new Exception("Usuário não encontrado!")));
    }

}
