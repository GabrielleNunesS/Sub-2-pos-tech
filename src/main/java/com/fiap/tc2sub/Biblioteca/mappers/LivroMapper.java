package com.fiap.tc2sub.Biblioteca.mappers;

import com.fiap.tc2sub.Biblioteca.dto.livro.request.LivroPostRequestDTO;
import com.fiap.tc2sub.Biblioteca.dto.livro.request.LivroPutRequestDTO;
import com.fiap.tc2sub.Biblioteca.dto.livro.response.LivroPostResponseDTO;
import com.fiap.tc2sub.Biblioteca.dto.livro.response.LivroPutResponseDTO;
import com.fiap.tc2sub.Biblioteca.entity.EntityLivro;
import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LivroMapper {
    LivroMapper INSTANCE = Mappers.getMapper(LivroMapper.class);

    LivroPutRequestDTO toLivroPutRequestDTO(Livro livro);
    LivroPutResponseDTO toLivroPutResponseDTO(Livro livro);

    LivroPostRequestDTO toLivroPostRequestDTO(Livro livro);
    LivroPostResponseDTO toLivroPostResponseDTO(Livro livro);

    Livro entityLivroToLivro(EntityLivro entityLivro);
    EntityLivro livroToEntityLivro(Livro livro);

    Livro toLivro(LivroPostRequestDTO livroPostRequestDTO);



}

