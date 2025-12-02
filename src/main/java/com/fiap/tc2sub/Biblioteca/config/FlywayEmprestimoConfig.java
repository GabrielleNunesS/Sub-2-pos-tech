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
                classes = com.fiap.tc2sub.Biblioteca.repositories.EmprestimoRepository.class
        ),
        entityManagerFactoryRef = "emprestimoEntityManagerFactory",
        transactionManagerRef = "emprestimoTransactionManager"
)
public class FlywayEmprestimoConfig {

    private final DataSource dataSourceEmprestimo;

    public FlywayEmprestimoConfig(@Qualifier("dataSourceEmprestimo") DataSource dataSourceEmprestimo) {
        this.dataSourceEmprestimo = dataSourceEmprestimo;
    }

    // -----------------------------
    // FLYWAY
    // -----------------------------
    @Bean(initMethod = "migrate")
    public Flyway flywayEmprestimo() {
        return Flyway.configure()
                .dataSource(dataSourceEmprestimo)
                .locations("classpath:db/migration/emprestimo")
                .baselineOnMigrate(true)
                .load();
    }

    // -----------------------------
    // ENTITY MANAGER
    // -----------------------------
    @Bean(name = "emprestimoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean emprestimoEntityManagerFactory(
            EntityManagerFactoryBuilder builder
    ) {
        return builder
                .dataSource(dataSourceEmprestimo)
                .packages("com.fiap.tc2sub.Biblioteca.entity") // <- EntityEmprestimo está aqui
                .persistenceUnit("emprestimoPU")
                .build();
    }

    // -----------------------------
    // TRANSACTION MANAGER
    // -----------------------------
    @Bean(name = "emprestimoTransactionManager")
    public PlatformTransactionManager emprestimoTransactionManager(
            @Qualifier("emprestimoEntityManagerFactory")
            EntityManagerFactory emprestimoEntityManagerFactory
    ) {
        return new JpaTransactionManager(emprestimoEntityManagerFactory);
    }
}
