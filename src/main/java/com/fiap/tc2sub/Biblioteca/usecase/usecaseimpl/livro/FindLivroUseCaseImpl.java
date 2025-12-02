package com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.livro;


import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import com.fiap.tc2sub.Biblioteca.model.livro.Page;
import com.fiap.tc2sub.Biblioteca.service.gateway.livro.FindLivroGateway;
import com.fiap.tc2sub.Biblioteca.usecase.livro.FindLivroUseCase;


import java.util.Optional;

public class FindLivroUseCaseImpl implements FindLivroUseCase {
    private final FindLivroGateway findLivroGateway;

    public FindLivroUseCaseImpl(FindLivroGateway findLivroGateway) {
        this.findLivroGateway = findLivroGateway;
    }

    @Override
    public Optional<Livro> findIsbn(String isbn){
        return findLivroGateway.findPorIsbn(Livro.validarIsbn(isbn));
    }

    @Override
    public Page<Livro> findAutor(String autor, int pageNumber, int pageSize) {
        if (autor == null || autor.isEmpty()) {
            throw new IllegalArgumentException("Autor não pode ser nulo ou vazio");
        }

        if (pageNumber < 0 || pageSize <= 0) {
            throw new IllegalArgumentException("Número da página e tamanho da página devem ser maiores que zero");
        }

        if (autor.length() < 3) {
            throw new IllegalArgumentException("O nome do autor deve ter pelo menos 3 caracteres");
        }

        return findLivroGateway.findPorAutor(autor, pageNumber, pageSize);
    }

    @Override
    public Page<Livro> findTitulo(String titulo, int pageNumber, int pageSize) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("Titulo não pode ser nulo ou vazio");
        }

        if (pageNumber < 0 || pageSize <= 0) {
            throw new IllegalArgumentException("Número da página e tamanho da página devem ser maiores que zero");
        }

        if (titulo.length() < 3) {
            throw new IllegalArgumentException("O titulo deve ter pelo menos 3 caracteres");
        }

        return findLivroGateway.findPorTitulo(titulo, pageNumber, pageSize);
    }

    @Override
    public Page<Livro> findEditora(String editora, int pageNumber, int pageSize) {
        if (editora == null || editora.isEmpty()) {
            throw new IllegalArgumentException("Editora não pode ser nulo ou vazio");
        }

        if (pageNumber < 0 || pageSize <= 0) {
            throw new IllegalArgumentException("Número da página e tamanho da página devem ser maiores que zero");
        }

        if (editora.length() < 3) {
            throw new IllegalArgumentException("A Editora deve ter pelo menos 3 caracteres");
        }

        return findLivroGateway.findPorEditora(editora, pageNumber, pageSize);
    }
}
