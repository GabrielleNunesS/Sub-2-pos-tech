package com.fiap.tc2sub.Biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@Table(name = "usuario")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntityUsuario {
    @Id
    @Column(name = "email", length = 50)
    private String email;

    @NotNull
    @Column(name = "nome", length = 100)
    private String nome;

    @NotNull
    @Column(name = "telefone", length = 15)
    private String telefone;

}