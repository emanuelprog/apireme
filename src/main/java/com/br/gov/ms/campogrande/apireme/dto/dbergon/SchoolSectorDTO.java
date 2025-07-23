package com.br.gov.ms.campogrande.apireme.dto.dbergon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolSectorDTO {
    private String sector;
    private Long schoolNumber;
}
