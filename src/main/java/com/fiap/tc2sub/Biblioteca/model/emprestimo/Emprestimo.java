package com.fiap.tc2sub.Biblioteca.model.emprestimo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * The type Emprestimo.
 */
@Getter
@Setter
public class Emprestimo {

    private String idLivro;
    private String idUsuario;
    private LocalDate dtIncEmprestimo;
    private LocalDate dtDevlcEmprestimo;
    private LocalDate dataRealDevolucao;


    /**
     * Instantiates a new Emprestimo.
     *
     * @param idLivro   the id livro
     * @param idUsuario the id usuario
     */
    public Emprestimo(String idLivro, String idUsuario) {
        this.idLivro = idLivro;
        this.idUsuario = idUsuario;
        this.dtIncEmprestimo = LocalDate.now();
        this.dtDevlcEmprestimo = LocalDate.now().plusDays(15);
        this.dataRealDevolucao = null;
    }

    public void atualizaDataDevolucao() {
        this.dataRealDevolucao = LocalDate.now();
    }
}
