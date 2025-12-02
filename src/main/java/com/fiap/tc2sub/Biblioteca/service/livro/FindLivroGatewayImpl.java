package com.fiap.tc2sub.Biblioteca.service.livro;


import com.fiap.tc2sub.Biblioteca.mappers.LivroMapper;
import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import com.fiap.tc2sub.Biblioteca.model.livro.Page;
import com.fiap.tc2sub.Biblioteca.repositories.LivroRepository;
import com.fiap.tc2sub.Biblioteca.service.gateway.livro.FindLivroGateway;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class FindLivroGatewayImpl implements FindLivroGateway {

    private final LivroRepository livroRepository;

    @Override
    public Optional<Livro> findPorIsbn(String isbn){
        return livroRepository.findByIsbn(Livro.validarIsbn(isbn)).map(LivroMapper.INSTANCE::entityLivroToLivro);
    }

    @Override
    public Page<Livro> findPorAutor(String autor, int pageNumber, int pageSize) {
        var pageable = PageRequest.of(pageNumber, pageSize);
        var livroPage = livroRepository.findByAutorContainingIgnoreCase(autor, pageable);

        return new Page<>(
                livroPage.getContent().stream()
                        .map(LivroMapper.INSTANCE::entityLivroToLivro)
                        .collect(Collectors.toList()),
                livroPage.getNumber(),
                livroPage.getSize(),
                livroPage.getTotalElements()
        );
    }

    @Override
    public Page<Livro> findPorTitulo(String titulo, int pageNumber, int pageSize) {
        var pageable = PageRequest.of(pageNumber, pageSize);
        var livroPage = livroRepository.findByTituloContainingIgnoreCase(titulo, pageable);

        return new Page<>(
                livroPage.getContent().stream()
                        .map(LivroMapper.INSTANCE::entityLivroToLivro)
                        .collect(Collectors.toList()),
                livroPage.getNumber(),
                livroPage.getSize(),
                livroPage.getTotalElements()
        );
    }

    @Override
    public Page<Livro> findPorEditora(String editora, int pageNumber, int pageSize) {
        var pageable = PageRequest.of(pageNumber, pageSize);
        var livroPage = livroRepository.findByEditoraContainingIgnoreCase(editora, pageable);

        return new Page<>(
                livroPage.getContent().stream()
                        .map(LivroMapper.INSTANCE::entityLivroToLivro)
                        .collect(Collectors.toList()),
                livroPage.getNumber(),
                livroPage.getSize(),
                livroPage.getTotalElements()
        );
    }
}
