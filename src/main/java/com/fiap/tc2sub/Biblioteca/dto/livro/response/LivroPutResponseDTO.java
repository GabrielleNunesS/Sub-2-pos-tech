package com.fiap.tc2sub.Biblioteca.dto.livro.response;

public record LivroPutResponseDTO(
        String isbn,
        String titulo,
        String autor,
        String editora,
        Integer quantidade
) {
}
