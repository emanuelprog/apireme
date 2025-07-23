package com.br.gov.ms.campogrande.apireme.model.dbergon;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ESCOLA_SETOR", schema = "EDUNET")
public class SchoolSector {

    @Id
    @Column(name = "SETOR")
    private String sector;

    @Column(name = "NUMESC")
    private Long schoolNumber;
}
