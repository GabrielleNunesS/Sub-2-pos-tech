package com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.emprestimo;


import com.fiap.tc2sub.Biblioteca.model.emprestimo.Emprestimo;
import com.fiap.tc2sub.Biblioteca.service.gateway.emprestimo.SaveEmprestimoGateway;
import com.fiap.tc2sub.Biblioteca.usecase.emprestimo.FindEmprestimoUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.emprestimo.SaveEmprestimoUseCase;

public class SaveEmprestimoUseCaseImpl implements SaveEmprestimoUseCase {

    private final FindEmprestimoUseCase findEmprestimoUseCase;
    private final SaveEmprestimoGateway saveEmprestimoGateway;

    public SaveEmprestimoUseCaseImpl(FindEmprestimoUseCase findEmprestimoUseCase, SaveEmprestimoGateway saveEmprestimoGateway) {
        this.findEmprestimoUseCase = findEmprestimoUseCase;
        this.saveEmprestimoGateway = saveEmprestimoGateway;
    }

    @Override
    public Emprestimo save(String idUsuario, String idLivro) throws Exception {
        // Valida a existencia do usuário
        findEmprestimoUseCase.findVerificaUsuario(idUsuario).orElseThrow(() -> new Exception("Usuario informado não existe"));

        // Valida a existencia do livro e sua disponibilidade
        findEmprestimoUseCase.findVerificaLivro(idLivro).orElseThrow(() -> new Exception("Livro informado não existe"));

        if (! findEmprestimoUseCase.findVerificaLivroDisponivel(idLivro)) {
            throw new Exception("Livro não está disponível para empréstimo");
        }

        // Valida se livro ja esta emprestado para o usuário
        if (findEmprestimoUseCase.findVerificaLivroEmprestado(idUsuario, idLivro)) {
            throw new Exception("Usuario já possui este livro emprestado");
        }

        return saveEmprestimoGateway.save(new Emprestimo(idUsuario, idLivro));
    }
}
