package com.br.gov.ms.campogrande.apireme.model.dbpreme;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tipo_frequencia", schema = "profweb")
public class FrequencyType {

    @Id
    @Column(name = "tipo_frequencia")
    private Long id;

    @Column(name = "descricao")
    private String description;

    @Column(name = "sigla")
    private String acronym;
}
