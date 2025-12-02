package com.fiap.tc2sub.Biblioteca.usecase.emprestimo;


public interface DeleteEmprestimoUseCase {
    void delete(String idUsuario, String idLivro) throws Exception;
}
