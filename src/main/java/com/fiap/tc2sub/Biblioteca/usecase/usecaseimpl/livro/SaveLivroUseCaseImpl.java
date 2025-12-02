package com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.livro;


import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import com.fiap.tc2sub.Biblioteca.service.gateway.livro.SaveLivroGateway;
import com.fiap.tc2sub.Biblioteca.usecase.livro.FindLivroUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.livro.SaveLivroUseCase;

public class SaveLivroUseCaseImpl implements SaveLivroUseCase {

    private final SaveLivroGateway saveLivroGateway;
    private final FindLivroUseCase findLivroUseCase;

    public SaveLivroUseCaseImpl(SaveLivroGateway saveLivroGateway, FindLivroUseCase findLivroUseCase) {
        this.saveLivroGateway = saveLivroGateway;
        this.findLivroUseCase = findLivroUseCase;
    }

    @Override
    public Livro save(Livro livro) throws Exception {
        if (findLivroUseCase.findIsbn(livro.getIsbn()).isPresent()) {
            throw new Exception("Livro já cadastrado");
        }
        return saveLivroGateway.save(livro);
    }
}
