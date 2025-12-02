package com.fiap.tc2sub.Biblioteca.controller;


import com.fiap.tc2sub.Biblioteca.model.emprestimo.Emprestimo;
import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import com.fiap.tc2sub.Biblioteca.usecase.emprestimo.EditEmprestimoUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.emprestimo.FindEmprestimoUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.emprestimo.SaveEmprestimoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmprestimoController {

    private final SaveEmprestimoUseCase saveEmprestimoUseCase;
    private final EditEmprestimoUseCase editEmprestimoUseCase;

    @PostMapping("emprestar/{usuarioId}/{livroIsbn}")
    public Emprestimo saveEmprestimo(@PathVariable String idUsuario, @PathVariable String idLivro) throws Exception {
        return saveEmprestimoUseCase.save(idUsuario, idLivro);
    }

    @PostMapping("devolver/{usuarioId}/{livroIsbn}")
    public void Devolucao(@PathVariable String idUsuario, @PathVariable String idLivro) throws Exception {
        editEmprestimoUseCase.editEmprestimo(idUsuario, idLivro);
    }
}
