package com.br.gov.ms.campogrande.apireme.config;

import org.hibernate.dialect.PostgreSQLDialect;

public class LegacyPostgreSQLDialect extends PostgreSQLDialect {

    public LegacyPostgreSQLDialect() {
        super();
    }

    @Override
    public boolean supportsIfExistsBeforeTableName() {
        // Permite o uso de "IF EXISTS" antes de nomes de tabelas, compatível com versões antigas
        return true;
    }

    @Override
    public boolean supportsColumnCheck() {
        // Verificação para restrições CHECK em colunas, compatível com versões antigas
        return true;
    }

    @Override
    public String getAddColumnString() {
        // Especifica o comando SQL para adicionar uma coluna, compatível com versões antigas
        return "add column";
    }

    @Override
    public boolean supportsCommentOn() {
        // Ajuste para comentários em tabelas/colunas, que podem não ser suportados em versões antigas
        return false;
    }

    @Override
    public boolean supportsCascadeDelete() {
        // Ajuste para deletar em cascata; versões antigas podem ter suporte limitado
        return false;
    }

    @Override
    public boolean dropConstraints() {
        // Define que constraints podem ser ignoradas na exclusão em versões antigas
        return false;
    }

    @Override
    public boolean supportsOuterJoinForUpdate() {
        // Ajuste para JOIN externo em operações de update
        return false;
    }

    @Override
    public String getDropForeignKeyString() {
        // Especifica o comando para remover uma foreign key, compatível com versões antigas
        return "drop constraint";
    }

    @Override
    public String getForUpdateString() {
        // Configura o uso de "FOR UPDATE" em queries de bloqueio
        return " for update";
    }

    @Override
    public boolean supportsCurrentTimestampSelection() {
        // Suporte para CURRENT_TIMESTAMP em SELECT, compatível com versões antigas
        return true;
    }

    @Override
    public boolean isCurrentTimestampSelectStringCallable() {
        // Define se CURRENT_TIMESTAMP é uma chamada de função
        return false;
    }

    @Override
    public String getCurrentTimestampSelectString() {
        // Retorna a expressão para selecionar o timestamp atual
        return "select now()";
    }

    @Override
    public boolean supportsUnionAll() {
        // Suporte para UNION ALL, compatível com versões antigas
        return true;
    }
}
