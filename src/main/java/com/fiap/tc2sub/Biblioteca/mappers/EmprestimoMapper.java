package com.fiap.tc2sub.Biblioteca.mappers;

import com.fiap.tc2sub.Biblioteca.dto.livro.request.LivroPostRequestDTO;
import com.fiap.tc2sub.Biblioteca.dto.livro.request.LivroPutRequestDTO;
import com.fiap.tc2sub.Biblioteca.dto.livro.response.LivroPostResponseDTO;
import com.fiap.tc2sub.Biblioteca.dto.livro.response.LivroPutResponseDTO;
import com.fiap.tc2sub.Biblioteca.entity.EntityEmprestimo;
import com.fiap.tc2sub.Biblioteca.entity.EntityLivro;
import com.fiap.tc2sub.Biblioteca.model.emprestimo.Emprestimo;
import com.fiap.tc2sub.Biblioteca.model.livro.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmprestimoMapper {
    EmprestimoMapper INSTANCE = Mappers.getMapper(EmprestimoMapper.class);

    Emprestimo entityEmprestimoToEmprestimo(EntityEmprestimo entityEmprestimo);;
    EntityEmprestimo emprestimoToEmprestimoEntity(Emprestimo emprestimo);


}

