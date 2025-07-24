package com.br.gov.ms.campogrande.apireme.model.dbpreme;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "frequencia_aluno", schema = "profweb")
public class StudentFrequency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "frequenciaalunoid")
    private Long id;

    @Column(name = "diarioclasseid")
    private Long diaryGradeId;

    @Column(name = "tipofrequenciaid")
    private Long frequencyTypeId;

    @Column(name = "data_frequencia")
    private Date frequencyDate;

    @Column(name = "codigo_reme")
    private Long studentId;

    @Column(name = "tempoaulaid")
    private Long classTimeId;

    @Column(name = "nome_aluno")
    private String studentName;

    @Column(name = "numero_chamada")
    private Long callNumber;

    @Column(name = "usualt")
    private String changeUser;
}
