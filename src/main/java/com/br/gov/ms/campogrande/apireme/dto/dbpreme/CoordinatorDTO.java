package com.br.gov.ms.campogrande.apireme.dto.dbpreme;

import lombok.Data;

@Data
public class CoordinatorDTO {
    private Long id;
    private Long enrollment;
    private String cpf;
    private String name;
    private String active;
}
