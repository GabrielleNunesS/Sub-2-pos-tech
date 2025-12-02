package com.fiap.tc2sub.Biblioteca.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Qualifier("dataSourceUsuario")
    @ConfigurationProperties(prefix = "spring.datasource.usuario")
    public DataSource dataSourceUsuario() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier("dataSourceLivro")
    @ConfigurationProperties(prefix = "spring.datasource.livro")
    public DataSource dataSourceLivro() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    @Qualifier("dataSourceEmprestimo")
    @ConfigurationProperties(prefix = "spring.datasource.emprestimo")
    public DataSource dataSourceEmprestimo() {
        return DataSourceBuilder.create().build();
    }
}
