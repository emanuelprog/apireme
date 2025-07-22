package com.br.gov.ms.campogrande.apireme.model.dbpreme;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tipoensino", schema = "profweb")
public class TeachingType {

    @Id
    @Column(name = "tipoensinoid")
    private Long id;

    @Column(name = "descricao")
    private String description;
}
