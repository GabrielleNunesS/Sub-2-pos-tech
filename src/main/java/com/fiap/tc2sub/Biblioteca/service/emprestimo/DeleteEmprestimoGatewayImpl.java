package com.fiap.tc2sub.Biblioteca.service.emprestimo;

import com.fiap.tc2sub.Biblioteca.repositories.EmprestimoRepository;
import com.fiap.tc2sub.Biblioteca.service.gateway.emprestimo.DeleteEmprestimoGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteEmprestimoGatewayImpl implements DeleteEmprestimoGateway {

    private final EmprestimoRepository emprestimoRepository;

    @Override
    public void delete(String idUsuario, String idLivro) {
        emprestimoRepository.delete(emprestimoRepository.findByIdUsuarioAndIdLivroAndDataRealDevolucaoIsNull(idUsuario, idLivro).orElseThrow(() -> new RuntimeException("Emprestimo não encontrado")));
    }
}
