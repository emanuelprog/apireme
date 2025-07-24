package com.br.gov.ms.campogrande.apireme.model.dbedu;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "dados_aluno", schema = "public")
public class Student {

    @Id
    @Column(name = "codigo_reme")
    private Long id;

    @Column(name = "matricula")
    private Long enrollment;

    @Column(name = "numero_chamada")
    private Long callNumber;

    @Column(name = "nome_aluno")
    private String name;

    @Column(name = "codigo_escola_ergon")
    private String sector;

    @Column(name = "etapa")
    private String descriptionGroup;

    @Column(name = "letra_classe")
    private String descriptionGrade;

    @Column(name = "turno")
    private String descriptionShift;

    @Column(name = "ano")
    private Long year;

    @Column(name = "codigo_ocorrencia")
    private Long occurrenceId;

    @Column(name = "tipo_ocorrencia")
    private String occurrenceType;

    @Column(name = "data_ocorrencia")
    private Date occurrenceDate;
}
