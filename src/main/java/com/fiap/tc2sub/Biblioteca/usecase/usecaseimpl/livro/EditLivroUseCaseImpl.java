package com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.livro;


import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import com.fiap.tc2sub.Biblioteca.service.gateway.livro.EditLivroGateway;
import com.fiap.tc2sub.Biblioteca.usecase.livro.EditLivroUseCase;

public class EditLivroUseCaseImpl implements EditLivroUseCase {

    private final EditLivroGateway editLivroGateway;

    public EditLivroUseCaseImpl(EditLivroGateway editLivroGateway) {
        this.editLivroGateway = editLivroGateway;
    }

    @Override
    public Livro editLivro(Livro livro) throws Exception {
        return editLivroGateway.edit(livro);
    }
}
