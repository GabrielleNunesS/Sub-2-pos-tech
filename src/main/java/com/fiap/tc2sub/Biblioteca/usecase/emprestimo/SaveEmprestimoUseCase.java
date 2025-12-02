package com.fiap.tc2sub.Biblioteca.usecase.emprestimo;


import com.fiap.tc2sub.Biblioteca.model.emprestimo.Emprestimo;

public interface SaveEmprestimoUseCase {
    Emprestimo save(String idUsuario, String idLivro) throws Exception;
}
