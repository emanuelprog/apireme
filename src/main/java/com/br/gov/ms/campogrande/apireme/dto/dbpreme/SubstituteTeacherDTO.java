package com.br.gov.ms.campogrande.apireme.dto.dbpreme;

import lombok.Data;

import java.util.Date;

@Data
public class SubstituteTeacherDTO {

    private Long id;
    private String substituteCPF;
    private String substituteName;
    private String substituteEnrollment;
    private Date replacementStartDate;
    private Date replacementEndDate;
    private String holderCPF;
    private String holderName;
    private String holderEnrollment;
    private Long holderEmploymentLink;
}
