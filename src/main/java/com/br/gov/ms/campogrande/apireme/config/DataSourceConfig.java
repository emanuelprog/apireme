package com.br.gov.ms.campogrande.apireme.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.simple.JdbcClient;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "dbpremeDataSourceProperties")
    @ConfigurationProperties(prefix = "app.datasource.dbpreme")
    public DataSourceProperties dbPREMEDsProps() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "dbpremeDataSource")
    public DataSource dbPREMEDs(@Qualifier("dbpremeDataSourceProperties") DataSourceProperties dsProps) {
        return dsProps.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name = "dbpremeJdbcClient")
    public JdbcClient dbPREMEJdbcClient(@Qualifier("dbpremeDataSource") DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }

    @Bean(name = "dbacessosDataSourceProperties")
    @ConfigurationProperties(prefix = "app.datasource.dbacessos")
    public DataSourceProperties dbAcessosDsProps() {
        return new DataSourceProperties();
    }

    @Bean(name = "dbacessosDataSource")
    public DataSource dbAcessosDs(@Qualifier("dbacessosDataSourceProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "dbacessosJdbcClient")
    public JdbcClient dbAcessosJdbcClient(@Qualifier("dbacessosDataSource") DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }

    @Bean(name = "dbergonDataSourceProperties")
    @ConfigurationProperties(prefix = "app.datasource.dbergon")
    public DataSourceProperties dbErgonDsProps() {
        return new DataSourceProperties();
    }

    @Bean(name = "dbergonDataSource")
    public DataSource dbErgonDs(@Qualifier("dbergonDataSourceProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "dbergonJdbcClient")
    public JdbcClient dbErgonJdbcClient(@Qualifier("dbergonDataSource") DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }
}
