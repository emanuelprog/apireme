package com.br.gov.ms.campogrande.apireme.model.dbergon;

import jakarta.persistence.*;
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

    @Column(name = "MATRICULA")
    private String enrollment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SETOR", referencedColumnName = "SETOR", insertable = false, updatable = false)
    private SchoolSector schoolSector;
}
