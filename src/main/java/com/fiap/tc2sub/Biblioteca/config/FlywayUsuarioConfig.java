package com.fiap.tc2sub.Biblioteca.config;

import jakarta.persistence.EntityManagerFactory;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.fiap.tc2sub.Biblioteca.repositories", // <- onde está UsuarioRepository
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = com.fiap.tc2sub.Biblioteca.repositories.UsuarioRepository.class
        ),
        entityManagerFactoryRef = "usuarioEntityManagerFactory",
        transactionManagerRef = "usuarioTransactionManager"
)
public class FlywayUsuarioConfig {

    private final DataSource dataSourceUsuario;

    public FlywayUsuarioConfig(@Qualifier("dataSourceUsuario") DataSource dataSourceUsuario) {
        this.dataSourceUsuario = dataSourceUsuario;
    }

    // ------------------------------
    // FLYWAY
    // ------------------------------
    @Bean(initMethod = "migrate")
    public Flyway flywayUsuario() {
        return Flyway.configure()
                .dataSource(dataSourceUsuario)
                .locations("classpath:db/migration/usuario")
                .baselineOnMigrate(true)
                .load();
    }

    // ------------------------------
    // ENTITY MANAGER (JPA)
    // ------------------------------
    @Primary
    @Bean("usuarioEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean usuarioEntityManagerFactory(
            EntityManagerFactoryBuilder builder
    ) {
        return builder
                .dataSource(dataSourceUsuario)
                .packages(
                        "com.fiap.tc2sub.Biblioteca.entity" // <- onde está EntityUsuario
                )
                .persistenceUnit("usuarioPU")
                .build();
    }

    // ------------------------------
    // TRANSACTION MANAGER
    // ------------------------------
    @Primary
    @Bean("usuarioTransactionManager")
    public PlatformTransactionManager usuarioTransactionManager(
            @Qualifier("usuarioEntityManagerFactory")
            EntityManagerFactory usuarioEntityManagerFactory
    ) {
        return new JpaTransactionManager(usuarioEntityManagerFactory);
    }
}
