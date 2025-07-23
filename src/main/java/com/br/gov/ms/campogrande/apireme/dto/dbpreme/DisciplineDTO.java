package com.br.gov.ms.campogrande.apireme.dto.dbpreme;

import lombok.Data;

@Data
public class DisciplineDTO {
    private Long id;
    private String description;
    private Boolean situation;
    private Long teachingTypeId;
    private Long disciplineDbeduId;
}
