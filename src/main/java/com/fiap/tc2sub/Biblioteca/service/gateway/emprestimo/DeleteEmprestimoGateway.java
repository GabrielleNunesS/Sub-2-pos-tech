package com.fiap.tc2sub.Biblioteca.service.gateway.emprestimo;

import com.fiap.tc2sub.Biblioteca.model.emprestimo.Emprestimo;

public interface DeleteEmprestimoGateway {
    void delete(String idUsuario, String idLivro);
}
