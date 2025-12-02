package com.fiap.tc2sub.Biblioteca.service.emprestimo;


import com.fiap.tc2sub.Biblioteca.entity.EntityEmprestimo;
import com.fiap.tc2sub.Biblioteca.mappers.EmprestimoMapper;
import com.fiap.tc2sub.Biblioteca.model.emprestimo.Emprestimo;
import com.fiap.tc2sub.Biblioteca.repositories.EmprestimoRepository;
import com.fiap.tc2sub.Biblioteca.service.gateway.emprestimo.EditEmprestimoGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EditEmprestimoGatewayImpl implements EditEmprestimoGateway {

    private final EmprestimoRepository emprestimoRepository;

    @Override
    public Emprestimo edit(Emprestimo emprestimo) {
        EntityEmprestimo entityEmprestimo = emprestimoRepository.findByIdUsuarioAndIdLivroAndDataRealDevolucaoIsNull(emprestimo.getIdUsuario(), emprestimo.getIdLivro())
                .map(existingEmprestimo -> {
                    existingEmprestimo.setDtIncEmprestimo(emprestimo.getDtIncEmprestimo());
                    existingEmprestimo.setDtDevlcEmprestimo(emprestimo.getDtDevlcEmprestimo());
                    existingEmprestimo.setDataRealDevolucao(emprestimo.getDataRealDevolucao());
                    return emprestimoRepository.save(existingEmprestimo);
                })
                .orElseThrow(() -> new RuntimeException("emprestimo não localizado"));

        return EmprestimoMapper.INSTANCE.entityEmprestimoToEmprestimo(entityEmprestimo);
    }
}
