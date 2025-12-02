package com.fiap.tc2sub.Biblioteca.config;

import com.fiap.tc2sub.Biblioteca.service.gateway.emprestimo.FindEmprestimoGateway;
import com.fiap.tc2sub.Biblioteca.service.gateway.emprestimo.SaveEmprestimoGateway;
import com.fiap.tc2sub.Biblioteca.service.gateway.emprestimo.EditEmprestimoGateway;
import com.fiap.tc2sub.Biblioteca.service.gateway.emprestimo.DeleteEmprestimoGateway;

import com.fiap.tc2sub.Biblioteca.usecase.emprestimo.FindEmprestimoUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.emprestimo.SaveEmprestimoUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.emprestimo.EditEmprestimoUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.emprestimo.DeleteEmprestimoUseCase;

import com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.emprestimo.FindEmprestimoUseCaseImpl;
import com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.emprestimo.SaveEmprestimoUseCaseImpl;
import com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.emprestimo.EditEmprestimoUseCaseImpl;
import com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.emprestimo.DeleteEmprestimoUseCaseImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmprestimoConfig {

    @Bean
    public FindEmprestimoUseCase findEmprestimoUseCase(FindEmprestimoGateway findEmprestimoGateway) {
        return new FindEmprestimoUseCaseImpl(findEmprestimoGateway);
    }

    @Bean
    public SaveEmprestimoUseCase saveEmprestimoUseCase(FindEmprestimoUseCase findEmprestimoUseCase, SaveEmprestimoGateway saveEmprestimoGateway) {
        return new SaveEmprestimoUseCaseImpl(findEmprestimoUseCase, saveEmprestimoGateway);
    }

    @Bean
    public EditEmprestimoUseCase editEmprestimoUseCase(FindEmprestimoUseCase findEmprestimoUseCase, EditEmprestimoGateway editEmprestimoGateway) {
        return new EditEmprestimoUseCaseImpl(findEmprestimoUseCase, editEmprestimoGateway);
    }

    @Bean
    public DeleteEmprestimoUseCase deleteEmprestimoUseCase(DeleteEmprestimoGateway deleteEmprestimoGateway) {
        return new DeleteEmprestimoUseCaseImpl(deleteEmprestimoGateway);
    }
}
