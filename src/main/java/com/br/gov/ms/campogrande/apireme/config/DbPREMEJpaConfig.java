package com.br.gov.ms.campogrande.apireme.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.br.gov.ms.campogrande.apireme.repository.dbpreme",
        entityManagerFactoryRef = "dbpremeEntityManagerFactory",
        transactionManagerRef = "dbpremeTransactionManager"
)
public class DbPREMEJpaConfig {

    @Primary
    @Bean(name = "dbpremeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean dbPREMEEntityManagerFactory(
            @Qualifier("dbpremeDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages("com.br.gov.ms.campogrande.apireme.model.dbpreme")
                .persistenceUnit("dbpreme")
                .build();
    }

    @Primary
    @Bean(name = "dbpremeTransactionManager")
    public PlatformTransactionManager dbPREMETransactionManager(
            @Qualifier("dbpremeEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
