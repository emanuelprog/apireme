package com.br.gov.ms.campogrande.apireme.model.dbpreme;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "horario_professor", schema = "profweb")
public class TeacherSchedule {

    @Id
    @Column(name = "horarioprofessorid")
    private Long id;

    @Column(name = "matricula")
    private String enrollment;

    @OneToOne
    @JoinColumn(name = "tipoensinoid")
    private TeachingType teachingType;

    @OneToOne
    @JoinColumn(name = "turnoid")
    private Shift shift;

    @Column(name = "numesc")
    private Long schoolNumber;

    @OneToOne
    @JoinColumn(name = "classeid")
    private Grade grade;

    @OneToOne
    @JoinColumn(name = "serieid")
    private Group groupId;

    @OneToOne
    @JoinColumn(name = "disciplinaid")
    private Discipline disciplineId;

    @Column(name = "anoreferencia")
    private Long year;
}
