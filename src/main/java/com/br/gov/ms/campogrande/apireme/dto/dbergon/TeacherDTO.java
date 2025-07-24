package com.br.gov.ms.campogrande.apireme.dto.dbergon;

import lombok.Data;

@Data
public class TeacherDTO {

    private Long enrollment;
    private Long employmentLink;
    private String cpf;
    private String name;
    private String departmentCode;
    private String departmentName;
    private Long role;
    private String specialty;
    private AddressDTO address;
    private String leaveStatus;
    private Boolean isCoordinator;

    private String holderCpf;
    private String holderName;
    private Long holderEmploymentLink;
    private Long substituteTeacherId;
}
