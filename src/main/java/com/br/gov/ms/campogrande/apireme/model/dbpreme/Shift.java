package com.br.gov.ms.campogrande.apireme.model.dbpreme;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "turno", schema = "profweb")
public class Shift {

    @Id
    @Column(name = "turnoid")
    private Long id;

    @Column(name = "descricao")
    private String description;

    @Column(name = "situacao")
    private Boolean situation;
}
