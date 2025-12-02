package com.fiap.tc2sub.Biblioteca.service.livro;

import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import com.fiap.tc2sub.Biblioteca.repositories.LivroRepository;
import com.fiap.tc2sub.Biblioteca.service.gateway.livro.DeleteLivroGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteLivroGatewayImpl implements DeleteLivroGateway {

    private final LivroRepository livroRepository;

    @Override
    public void delete(String isbn) {
        livroRepository.delete(livroRepository.findByIsbn(Livro.validarIsbn(isbn)).orElseThrow(() -> new RuntimeException("Livro não encontrado")));
    }
}
