package com.br.gov.ms.campogrande.apireme.model.dbpreme;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "professor_substituto", schema = "profweb")
public class SubstituteTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_substitutoid")
    private Long id;

    @Column(name = "cpf_substituto")
    private String substituteCPF;

    @Column(name = "nome_substituto")
    private String substituteName;

    @Column(name = "matricula_substituto")
    private String substituteEnrollment;

    @Column(name = "data_inicio_substituicao")
    private Date replacementStartDate;

    @Column(name = "data_fim_substituicao")
    private Date replacementEndDate;

    @Column(name = "cpf_titular")
    private String holderCPF;

    @Column(name = "nome_titular")
    private String holderName;

    @Column(name = "matricula_titular")
    private String holderEnrollment;
}
