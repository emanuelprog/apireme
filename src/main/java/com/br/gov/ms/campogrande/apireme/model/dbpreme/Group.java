package com.br.gov.ms.campogrande.apireme.model.dbpreme;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "serie", schema = "profweb")
public class Group {

    @Id
    @Column(name = "serieid")
    private Long id;

    @Column(name = "descricao")
    private String description;

    @Column(name = "tipoensinoid")
    private Long teachingTypeId;
}
