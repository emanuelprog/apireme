package com.br.gov.ms.campogrande.apireme.model.dbpreme;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "disciplina", schema = "profweb")
public class Discipline {

    @Id
    @Column(name = "disciplinaid")
    private Long id;

    @Column(name = "descricao")
    private String description;

    @Column(name = "situacao")
    private Boolean situation;

    @Column(name = "tipoensinoid")
    private Long teachingTypeId;

    @Column(name = "codigo_disciplina_dbedu")
    private Long disciplineDbeduId;
}
