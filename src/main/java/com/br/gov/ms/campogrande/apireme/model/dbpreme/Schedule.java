package com.br.gov.ms.campogrande.apireme.model.dbpreme;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "horario", schema = "profweb")
public class Schedule {

    @Id
    @Column(name = "horarioid")
    private Long id;

    @Column(name = "horarioprofessorid")
    private Long teacherScheduleId;

    @Column(name = "tempoaulaid")
    private Long classTimeId;

    @ManyToOne
    @JoinColumn(name = "segunda")
    private Discipline monday;

    @ManyToOne
    @JoinColumn(name = "segundagrupoano")
    private Group mondayGroup;

    @ManyToOne
    @JoinColumn(name = "segundaturma")
    private Grade mondayGrade;

    @ManyToOne
    @JoinColumn(name = "terca")
    private Discipline tuesday;

    @ManyToOne
    @JoinColumn(name = "tercagrupoano")
    private Group tuesdayGroup;

    @ManyToOne
    @JoinColumn(name = "tercaturma")
    private Grade tuesdayGrade;

    @ManyToOne
    @JoinColumn(name = "quarta")
    private Discipline wednesday;

    @ManyToOne
    @JoinColumn(name = "quartagrupoano")
    private Group wednesdayGroup;

    @ManyToOne
    @JoinColumn(name = "quartaturma")
    private Grade wednesdayGrade;

    @ManyToOne
    @JoinColumn(name = "quinta")
    private Discipline thursday;

    @ManyToOne
    @JoinColumn(name = "quintagrupoano")
    private Group thursdayGroup;

    @ManyToOne
    @JoinColumn(name = "quintaturma")
    private Grade thursdayGrade;

    @ManyToOne
    @JoinColumn(name = "sexta")
    private Discipline friday;

    @ManyToOne
    @JoinColumn(name = "sextagrupoano")
    private Group fridayGroup;

    @ManyToOne
    @JoinColumn(name = "sextaturma")
    private Grade fridayGrade;

    @Column(name = "turnoid")
    private Long shiftId;
}
