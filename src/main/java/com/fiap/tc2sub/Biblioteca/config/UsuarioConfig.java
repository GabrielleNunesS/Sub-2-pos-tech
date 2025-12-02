package com.fiap.tc2sub.Biblioteca.config;

import com.fiap.tc2sub.Biblioteca.service.gateway.usuario.DeleteUsuarioGateway;
import com.fiap.tc2sub.Biblioteca.service.gateway.usuario.EditUsuarioGateway;
import com.fiap.tc2sub.Biblioteca.service.gateway.usuario.FindUsuarioGateway;
import com.fiap.tc2sub.Biblioteca.service.gateway.usuario.SaveUsuarioGateway;
import com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.usuario.DeleteUsuarioUseCaseImpl;
import com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.usuario.EditUsuarioUseCaseImpl;
import com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.usuario.FindUsuarioUseCaseImpl;
import com.fiap.tc2sub.Biblioteca.usecase.usecaseimpl.usuario.SaveUsuarioUseCaseImpl;
import com.fiap.tc2sub.Biblioteca.usecase.usuario.DeleteUsuarioUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.usuario.EditUsuarioUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.usuario.FindUsuarioUseCase;
import com.fiap.tc2sub.Biblioteca.usecase.usuario.SaveUsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    FindUsuarioUseCase findUsuarioUseCase(FindUsuarioGateway findUsuarioGateway) {
        return new FindUsuarioUseCaseImpl(findUsuarioGateway);
    }

    @Bean
    SaveUsuarioUseCase saveUsuarioUseCase(SaveUsuarioGateway saveUsuarioGateway, FindUsuarioUseCase findUsuarioUseCase) {
        return new SaveUsuarioUseCaseImpl(saveUsuarioGateway, findUsuarioUseCase);
    }

    @Bean
    DeleteUsuarioUseCase deleteUsuarioUseCase(DeleteUsuarioGateway deleteUsuarioGateway) {
        return new DeleteUsuarioUseCaseImpl(deleteUsuarioGateway);
    }

    @Bean
    EditUsuarioUseCase editUsuarioUseCase(EditUsuarioGateway editUsuarioGateway) {
        return new EditUsuarioUseCaseImpl(editUsuarioGateway);
    }

}

