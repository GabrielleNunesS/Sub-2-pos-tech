package com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.emprestimo;

import com.fiap.tc2sub.Biblioteca.service.gateway.emprestimo.DeleteEmprestimoGateway;
import com.fiap.tc2sub.Biblioteca.usecase.emprestimo.DeleteEmprestimoUseCase;

public class DeleteEmprestimoUseCaseImpl implements DeleteEmprestimoUseCase {
    private final DeleteEmprestimoGateway deleteEmprestimoGateway;

    public DeleteEmprestimoUseCaseImpl(DeleteEmprestimoGateway deleteEmprestimoGateway) {
        this.deleteEmprestimoGateway = deleteEmprestimoGateway;
    }

    @Override
    public void delete(String idUsuario, String idLivro) {
        deleteEmprestimoGateway.delete(idUsuario, idLivro);
    }
}
