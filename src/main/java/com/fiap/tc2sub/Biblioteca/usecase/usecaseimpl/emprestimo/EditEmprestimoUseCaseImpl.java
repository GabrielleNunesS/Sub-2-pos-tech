package com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.emprestimo;


import com.fiap.tc2sub.Biblioteca.model.emprestimo.Emprestimo;
import com.fiap.tc2sub.Biblioteca.service.gateway.emprestimo.EditEmprestimoGateway;
import com.fiap.tc2sub.Biblioteca.usecase.emprestimo.EditEmprestimoUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.emprestimo.FindEmprestimoUseCase;

public class EditEmprestimoUseCaseImpl implements EditEmprestimoUseCase {


    private final FindEmprestimoUseCase findEmprestimoUseCase;
    private final EditEmprestimoGateway editEmprestimoGateway;

    public EditEmprestimoUseCaseImpl(FindEmprestimoUseCase findEmprestimoUseCase, EditEmprestimoGateway editEmprestimoGateway) {
        this.findEmprestimoUseCase = findEmprestimoUseCase;
        this.editEmprestimoGateway = editEmprestimoGateway;
    }

    @Override
    public void editEmprestimo(String idUsuario, String idLivro) throws Exception {
        findEmprestimoUseCase.findVerificaUsuario(idUsuario).orElseThrow(() -> new Exception("Usuário não encontrado!"));
        findEmprestimoUseCase.findVerificaLivro(idLivro).orElseThrow(() -> new Exception("Livro não encontrado!"));

        Emprestimo emprestimo = findEmprestimoUseCase.findVerificaEmprestimo(idUsuario, idLivro).orElseThrow(() -> new Exception("Empréstimo não encontrado!"));

        emprestimo.atualizaDataDevolucao();

        // Aqui você pode adicionar a lógica para atualizar o status do empréstimo no banco de dados ou em outro repositório

        editEmprestimoGateway.edit(emprestimo);
    }
}
