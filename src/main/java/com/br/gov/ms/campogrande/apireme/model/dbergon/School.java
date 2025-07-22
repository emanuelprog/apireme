package com.br.gov.ms.campogrande.apireme.model.dbergon;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CERG_DADOS_PROFESSORES", schema = "EDUNET")
public class School {

    @Id
    @Column(name = "SETOR")
    private String sector;

    @Column(name = "NOME_SETOR")
    private String sectorName;

    @Column(name = "matricula")
    private String enrollment;
}
