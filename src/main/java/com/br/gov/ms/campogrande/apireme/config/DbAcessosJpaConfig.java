package com.br.gov.ms.campogrande.apireme.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.br.gov.ms.campogrande.apireme.repository.dbacessos",
        entityManagerFactoryRef = "dbAcessosEntityManagerFactory",
        transactionManagerRef = "dbAcessosTransactionManager"
)
public class DbAcessosJpaConfig {

    @Bean(name = "dbAcessosEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean dbAcessosEntityManagerFactory(
            @Qualifier("dbacessosDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages("com.br.gov.ms.campogrande.apireme.model.dbacessos")
                .persistenceUnit("dbacessos")
                .build();
    }

    @Bean(name = "dbAcessosTransactionManager")
    public PlatformTransactionManager dbAcessosTransactionManager(
            @Qualifier("dbAcessosEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
