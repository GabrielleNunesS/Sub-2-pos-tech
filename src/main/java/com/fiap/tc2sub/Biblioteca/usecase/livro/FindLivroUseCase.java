package com.fiap.tc2sub.Biblioteca.usecase.livro;


import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import com.fiap.tc2sub.Biblioteca.model.livro.Page;

import java.util.Optional;

public interface FindLivroUseCase {
    Optional<Livro> findIsbn(String isbn);
    Page<Livro> findAutor(String autor, int pageNumber, int pageSize);
    Page<Livro> findTitulo(String titulo, int numeroPagina, int tamanhoPagina);
    Page<Livro> findEditora(String editora, int numeroPagina, int tamanhoPagina);
}
