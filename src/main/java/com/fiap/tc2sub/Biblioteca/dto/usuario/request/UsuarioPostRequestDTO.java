package com.fiap.tc2sub.Biblioteca.dto.usuario.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record UsuarioPostRequestDTO(
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        String email,
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "Telefone é obrigatório")
        @Length(min = 11, max = 15, message = "Telefone deve ter entre 11 e 15 caracteres")
        String telefone
) {
}
