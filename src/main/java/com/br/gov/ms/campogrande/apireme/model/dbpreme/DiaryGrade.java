package com.br.gov.ms.campogrande.apireme.model.dbpreme;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "diario_classe", schema = "profweb")
public class DiaryGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diarioclasseid")
    private Long id;

    @Column(name = "numesc")
    private String sector;

    @ManyToOne
    @JoinColumn(name = "serieid")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "turnoid")
    private Shift shift;

    @ManyToOne
    @JoinColumn(name = "classeid")
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "tipoensinoid")
    private TeachingType teachingType;

    @Column(name = "professorsubstitutoid")
    private Long substituteTeacherId;

    @Column(name = "matricula_titular")
    private String enrollment;

    @Column(name = "vinculo")
    private Long employmentLink;

    @ManyToOne
    @JoinColumn(name = "periodo_bimestreid")
    private BimesterPeriod bimesterPeriod;

    @ManyToOne
    @JoinColumn(name = "disciplinaid")
    private Discipline discipline;

    @Column(name = "horarioprofessorid")
    private Long teacherScheduleId;

    @Column(name = "tipodiario")
    private String diaryType;

    @Column(name = "tipoavaliacaoid")
    private Long assessmentTypeId;

    @Column(name = "usualt")
    private String changeUser;

    @Column(name = "termo")
    private Boolean term;

    @Column(name = "datainclusao")
    private Date createdAt;
}
