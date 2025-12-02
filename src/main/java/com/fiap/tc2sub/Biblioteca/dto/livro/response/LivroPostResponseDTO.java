package com.fiap.tc2sub.Biblioteca.dto.livro.response;

public record LivroPostResponseDTO(
        String isbn,
        String titulo,
        String autor,
        String editora,
        Integer quantidade
) {
}
