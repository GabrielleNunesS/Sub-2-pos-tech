package com.fiap.tc2sub.Biblioteca.config;


import com.fiap.tc2sub.Biblioteca.service.gateway.livro.DeleteLivroGateway;
import com.fiap.tc2sub.Biblioteca.service.gateway.livro.EditLivroGateway;
import com.fiap.tc2sub.Biblioteca.service.gateway.livro.FindLivroGateway;
import com.fiap.tc2sub.Biblioteca.service.gateway.livro.SaveLivroGateway;
import com.fiap.tc2sub.Biblioteca.usecase.livro.DeleteLivroUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.livro.EditLivroUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.livro.FindLivroUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.livro.SaveLivroUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.livro.DeleteLivroUseCaseImpl;
import com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.livro.EditLivroUseCaseImpl;
import com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.livro.FindLivroUseCaseImpl;
import com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.livro.SaveLivroUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LivroConfig {
    @Bean
    SaveLivroUseCase saveLivroUseCase(SaveLivroGateway saveLivroGateway, FindLivroUseCase findLivroUseCase) {
        return new SaveLivroUseCaseImpl(saveLivroGateway, findLivroUseCase);
    }

    @Bean
    EditLivroUseCase editLivroUseCase(EditLivroGateway editLivroGateway) {
        return new EditLivroUseCaseImpl(editLivroGateway);
    }

    @Bean
    DeleteLivroUseCase deleteLivroUseCase(DeleteLivroGateway deleteLivroGateway) {
        return new DeleteLivroUseCaseImpl(deleteLivroGateway);
    }

    @Bean
    FindLivroUseCase findLivroUseCase(FindLivroGateway findLivroGateway) {
        return new FindLivroUseCaseImpl(findLivroGateway);
    }

}
