package com.br.gov.ms.campogrande.apireme.model.dbpreme;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "coordenadores_escolas", schema = "profweb")
public class SchoolCoordinator {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "setor")
    private String sector;

    @Column(name = "nome_setor")
    private String sectorName;

    @Column(name = "matricula")
    private String enrollment;
}
