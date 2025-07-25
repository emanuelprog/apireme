package com.br.gov.ms.campogrande.apireme.dto.dbergon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDTO {
    private String sector;
    private String sectorName;
    private String enrollment;
    private Long schoolNumber;
}
