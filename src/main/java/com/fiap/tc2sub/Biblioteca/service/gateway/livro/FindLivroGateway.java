package com.fiap.tc2sub.Biblioteca.service.gateway.livro;

import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import com.fiap.tc2sub.Biblioteca.model.livro.Page;

import java.util.Optional;

public interface FindLivroGateway {
    Optional<Livro> findPorIsbn(String isbn);
    Page<Livro> findPorAutor(String autor, int pageNumber, int pageSize);
    Page<Livro> findPorTitulo(String titulo, int numeroPagina, int tamanhoPagina);
    Page<Livro> findPorEditora(String editora, int numeroPagina, int tamanhoPagina);
}
