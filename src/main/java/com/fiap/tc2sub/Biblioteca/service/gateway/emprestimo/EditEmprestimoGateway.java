package com.fiap.tc2sub.Biblioteca.service.gateway.emprestimo;

import com.fiap.tc2sub.Biblioteca.model.emprestimo.Emprestimo;
import com.fiap.tc2sub.Biblioteca.model.livro.Livro;

public interface EditEmprestimoGateway {
    Emprestimo edit(Emprestimo emprestimo);
}
