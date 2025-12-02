package com.fiap.tc2sub.Biblioteca.service.emprestimo;


import com.fiap.tc2sub.Biblioteca.dto.livro.response.LivroPostResponseDTO;
import com.fiap.tc2sub.Biblioteca.entity.EntityEmprestimo;
import com.fiap.tc2sub.Biblioteca.entity.EntityLivro;
import com.fiap.tc2sub.Biblioteca.mappers.EmprestimoMapper;
import com.fiap.tc2sub.Biblioteca.model.emprestimo.Emprestimo;
import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import com.fiap.tc2sub.Biblioteca.model.usuario.Usuario;
import com.fiap.tc2sub.Biblioteca.repositories.EmprestimoRepository;
import com.fiap.tc2sub.Biblioteca.repositories.LivroRepository;
import com.fiap.tc2sub.Biblioteca.service.gateway.emprestimo.FindEmprestimoGateway;
import com.fiap.tc2sub.Biblioteca.usecase.livro.FindLivroUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.usuario.FindUsuarioUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FindEmprestimoGatewayImpl implements FindEmprestimoGateway {

    private final LivroRepository livroRepository;

    private final FindLivroUseCase findLivroUseCase;

    private final FindUsuarioUseCase findUsuarioUseCase;

    private final EmprestimoRepository emprestimoRepository;


    @Override
    public Optional<Emprestimo> findVerificaEmprestimo(String idUsuario, String idLivro) {
        EntityEmprestimo emprestimo = emprestimoRepository.findByIdUsuarioAndIdLivroAndDataRealDevolucaoIsNull(idUsuario, idLivro).orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        return Optional.ofNullable(EmprestimoMapper.INSTANCE.entityEmprestimoToEmprestimo(emprestimo));
    }

    @Override
    public boolean findVerificaLivroDisponivel(String idLivro) throws Exception {

        Livro livro = findLivroUseCase.findIsbn(idLivro).orElseThrow(() -> new Exception("Livro não encontrado"));

        int size = emprestimoRepository.findAllByIdLivroAndDataRealDevolucaoIsNull(idLivro).size();

        return (livro.getQuantidade() > size);
    }

    @Override
    public boolean findVerificaLivroEmprestado(String idUsuario, String idLivro) {
        return !emprestimoRepository.findByIdUsuarioAndIdLivroAndDataRealDevolucaoIsNull(idUsuario, idLivro).isEmpty();
    }

    @Override
    public Optional<Livro> findVerificaLivro(String isbn) {
        Optional<EntityLivro> LivroPostResponseDTO = livroRepository.findByIsbn(isbn);

        if (LivroPostResponseDTO == null) {
            return Optional.empty();
        }

        return Optional.of(new Livro(
                LivroPostResponseDTO.get().getIsbn(),
                LivroPostResponseDTO.get().getTitulo(),
                LivroPostResponseDTO.get().getAutor(),
                LivroPostResponseDTO.get().getEditora(),
                LivroPostResponseDTO.get().getQuantidade()
        ));
    }

    @Override
    public Optional<String> findVerificaUsuario(String idUsuario) throws Exception {
        Optional<Usuario> usuario = findUsuarioUseCase.findUsuario(idUsuario);
        if(usuario.isEmpty()){
            throw new Exception("Usuário não encontrado!");
        }
        return Optional.ofNullable(usuario.get().getEmail());
    }
}