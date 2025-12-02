package com.fiap.tc2sub.Biblioteca.service.livro;


import com.fiap.tc2sub.Biblioteca.entity.EntityLivro;
import com.fiap.tc2sub.Biblioteca.mappers.LivroMapper;
import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import com.fiap.tc2sub.Biblioteca.repositories.LivroRepository;
import com.fiap.tc2sub.Biblioteca.service.gateway.livro.SaveLivroGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SaveLivroGatewayImpl implements SaveLivroGateway {
    private final LivroRepository livroRepository;

    @Override
    public Livro save(Livro livro) {
        EntityLivro saved = livroRepository.save(LivroMapper.INSTANCE.livroToEntityLivro(livro));
        return  LivroMapper.INSTANCE.entityLivroToLivro(saved);
    }
}
