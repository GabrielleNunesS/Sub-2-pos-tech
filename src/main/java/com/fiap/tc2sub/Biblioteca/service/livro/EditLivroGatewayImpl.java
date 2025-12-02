package com.fiap.tc2sub.Biblioteca.service.livro;


import com.fiap.tc2sub.Biblioteca.entity.EntityLivro;
import com.fiap.tc2sub.Biblioteca.mappers.LivroMapper;
import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import com.fiap.tc2sub.Biblioteca.repositories.LivroRepository;
import com.fiap.tc2sub.Biblioteca.service.gateway.livro.EditLivroGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EditLivroGatewayImpl implements EditLivroGateway {

    private final LivroRepository livroRepository;

    @Override
    public Livro edit(Livro livro) {
        EntityLivro entityLivro = livroRepository.findByIsbn(livro.getIsbn())
                .map(existingLivro -> {
                    existingLivro.setIsbn(livro.getIsbn());
                    existingLivro.setTitulo(livro.getTitulo());
                    existingLivro.setAutor(livro.getAutor());
                    existingLivro.setEditora(livro.getEditora());
                    return livroRepository.save(existingLivro);
                })
                .orElseThrow(() -> new RuntimeException("livro não localizado"));

        return LivroMapper.INSTANCE.entityLivroToLivro(entityLivro);
    }
}
