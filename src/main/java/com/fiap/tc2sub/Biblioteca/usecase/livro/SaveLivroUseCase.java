package com.fiap.tc2sub.Biblioteca.usecase.livro;


import com.fiap.tc2sub.Biblioteca.model.livro.Livro;

public interface SaveLivroUseCase {
    Livro save(Livro livro) throws Exception;
}
