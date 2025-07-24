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
        basePackages = "com.br.gov.ms.campogrande.apireme.repository.dbedu",
        entityManagerFactoryRef = "dbEduEntityManagerFactory",
        transactionManagerRef = "dbEduTransactionManager"
)
public class DbEduJpaConfig {

    @Bean(name = "dbEduEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean dbEduEntityManagerFactory(
            @Qualifier("dbeduDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages("com.br.gov.ms.campogrande.apireme.model.dbedu")
                .persistenceUnit("dbedu")
                .build();
    }

    @Bean(name = "dbEduTransactionManager")
    public PlatformTransactionManager dbEduTransactionManager(
            @Qualifier("dbEduEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
