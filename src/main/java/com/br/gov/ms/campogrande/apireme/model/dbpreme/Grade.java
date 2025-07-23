package com.br.gov.ms.campogrande.apireme.model.dbpreme;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "classe", schema = "profweb")
public class Grade {

    @Id
    @Column(name = "classeid")
    private Long id;

    @Column(name = "descricao")
    private String description;

    @Column(name = "situacao")
    private Boolean situation;
}
