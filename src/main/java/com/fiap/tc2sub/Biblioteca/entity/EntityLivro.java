package com.fiap.tc2sub.Biblioteca.entity;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@Table(name = "livro")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntityLivro {

    @Id
    @Column(name = "isbn", length = 13)
    private String isbn;

    @NotNull
    @Column(name = "titulo", length = 150)
    private String titulo;

    @Column(name = "autor", length = 100)
    private String autor;

    @Column(name = "editora", length = 100)
    private String editora;

    @NotNull
    @Column(name = "quantidade")
    private Integer quantidade;

}
