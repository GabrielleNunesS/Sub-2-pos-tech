package com.fiap.tc2sub.Biblioteca.config;

import jakarta.persistence.EntityManagerFactory;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.fiap.tc2sub.Biblioteca.repositories",
        includeFilters = @Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = com.fiap.tc2sub.Biblioteca.repositories.LivroRepository.class
        ),
        entityManagerFactoryRef = "livroEntityManagerFactory",
        transactionManagerRef = "livroTransactionManager"
)
public class FlywayLivroConfig {

    private final DataSource dataSourceLivro;

    public FlywayLivroConfig(@Qualifier("dataSourceLivro") DataSource dataSourceLivro) {
        this.dataSourceLivro = dataSourceLivro;
    }

    // -----------------------------
    // FLYWAY (já existia)
    // -----------------------------
    @Bean(initMethod = "migrate")
    public Flyway flywayLivro() {
        return Flyway.configure()
                .dataSource(dataSourceLivro)
                .locations("classpath:db/migration/livro")
                .baselineOnMigrate(true)
                .load();
    }

    // -----------------------------
    // ENTITY MANAGER
    // -----------------------------
    @Bean(name = "livroEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean livroEntityManagerFactory(
            EntityManagerFactoryBuilder builder
    ) {
        return builder
                .dataSource(dataSourceLivro)
                .packages("com.fiap.tc2sub.Biblioteca.entity") // <- EntityLivro está aqui
                .persistenceUnit("livroPU")
                .build();
    }

    // -----------------------------
    // TRANSACTION MANAGER
    // -----------------------------
    @Bean(name = "livroTransactionManager")
    public PlatformTransactionManager livroTransactionManager(
            @Qualifier("livroEntityManagerFactory")
            EntityManagerFactory livroEntityManagerFactory
    ) {
        return new JpaTransactionManager(livroEntityManagerFactory);
    }
}
