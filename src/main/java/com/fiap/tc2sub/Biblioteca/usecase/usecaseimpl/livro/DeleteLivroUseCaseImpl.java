package com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.livro;


import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import com.fiap.tc2sub.Biblioteca.service.gateway.livro.DeleteLivroGateway;
import com.fiap.tc2sub.Biblioteca.usecase.livro.DeleteLivroUseCase;

public class DeleteLivroUseCaseImpl implements DeleteLivroUseCase {
    private final DeleteLivroGateway deleteLivroGateway;

    public DeleteLivroUseCaseImpl(DeleteLivroGateway deleteLivroGateway) {
        this.deleteLivroGateway = deleteLivroGateway;
    }

    @Override
    public void delete(String isbn) {
        deleteLivroGateway.delete(Livro.validarIsbn(isbn));
    }
}
