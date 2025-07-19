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
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.br.gov.ms.campogrande.apireme.repository.dbergon",
        entityManagerFactoryRef = "dbErgonEntityManagerFactory",
        transactionManagerRef = "dbErgonTransactionManager"
)
public class DbErgonJpaConfig {

    @Bean(name = "dbErgonEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean dbErgonEntityManagerFactory(
            @Qualifier("dbergonDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {

        Map<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
        jpaProperties.put("hibernate.hbm2ddl.auto", "none");
        jpaProperties.put("hibernate.show_sql", false);

        return builder
                .dataSource(dataSource)
                .packages("com.br.gov.ms.campogrande.apireme.model.dbergon")
                .persistenceUnit("dbergon")
                .properties(jpaProperties)
                .build();
    }

    @Bean(name = "dbErgonTransactionManager")
    public PlatformTransactionManager dbErgonTransactionManager(
            @Qualifier("dbErgonEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}