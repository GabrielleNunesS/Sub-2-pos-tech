package com.fiap.tc2sub.Biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDate;
import java.util.UUID;

@Table(name = "emprestimo")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntityEmprestimo {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "idLivro")
    private String idLivro;

    @Column(name = "idUsuario")
    private String idUsuario;

    @Column(name = "dtIncEmprestimo")
    private LocalDate dtIncEmprestimo;

    @Column(name = "dtDevlcEmprestimo")
    private LocalDate dtDevlcEmprestimo;

    @Column(name = "dataRealDevolucao")
    private LocalDate dataRealDevolucao;
}
