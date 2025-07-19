package com.br.gov.ms.campogrande.apireme.model.dbergon;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "CERG_DADOS_PROFESSORES", schema = "EDUNET")
public class Teacher {

    @Id
    @Column(name = "MATRICULA")
    private Long enrollment;

    @Column(name = "VINCULO")
    private Long employmentLink;

    @Column(name = "NUMFUNC")
    private Long employeeNumber;

    @Column(name = "NUMVINC")
    private Long linkNumber;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "NOME")
    private String name;

    @Column(name = "DTINI_EVENTO")
    @Temporal(TemporalType.DATE)
    private Date eventStartDate;

    @Column(name = "DTFIM_EVENTO")
    @Temporal(TemporalType.DATE)
    private Date eventEndDate;

    @Column(name = "SETOR")
    private String departmentCode;

    @Column(name = "NOME_SETOR")
    private String departmentName;

    @Column(name = "DTNASC")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "E_MAIL")
    private String email;

    @Column(name = "TELEFONE")
    private String phone;

    @Column(name = "NUMTEL_CELULAR")
    private String mobile;

    @Column(name = "CARGO")
    private Long role;

    @Column(name = "ESPECIALIDADE")
    private String specialty;

    @Embedded
    private Address address;

    @Column(name = "LIC_AFAST")
    private String leaveStatus;

    @Column(name = "NUMEV")
    private Long externalId;
}