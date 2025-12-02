package com.fiap.tc2sub.Biblioteca.service.emprestimo;


import com.fiap.tc2sub.Biblioteca.entity.EntityEmprestimo;
import com.fiap.tc2sub.Biblioteca.entity.EntityLivro;
import com.fiap.tc2sub.Biblioteca.mappers.EmprestimoMapper;
import com.fiap.tc2sub.Biblioteca.mappers.LivroMapper;
import com.fiap.tc2sub.Biblioteca.model.emprestimo.Emprestimo;
import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import com.fiap.tc2sub.Biblioteca.repositories.EmprestimoRepository;
import com.fiap.tc2sub.Biblioteca.repositories.LivroRepository;
import com.fiap.tc2sub.Biblioteca.service.gateway.emprestimo.SaveEmprestimoGateway;
import com.fiap.tc2sub.Biblioteca.service.gateway.livro.SaveLivroGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SaveEmprestimoGatewayImpl implements SaveEmprestimoGateway {
    private final EmprestimoRepository emprestimoRepository;

    @Override
    public Emprestimo save(Emprestimo emprestimo) {
        EntityEmprestimo save = emprestimoRepository.save(EmprestimoMapper.INSTANCE.emprestimoToEmprestimoEntity(emprestimo));
        return  EmprestimoMapper.INSTANCE.entityEmprestimoToEmprestimo(save);
    }
}
