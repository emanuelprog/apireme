package com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency;

import lombok.Data;

@Data
public class FrequencyEntryDTO {
    private Long id;
    private String classTime;
    private String date;
    private String value;
}
