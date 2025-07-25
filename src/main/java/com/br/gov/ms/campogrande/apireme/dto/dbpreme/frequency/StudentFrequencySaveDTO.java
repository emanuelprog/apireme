package com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency;

import lombok.Data;

import java.util.List;

@Data
public class StudentFrequencySaveDTO {
    private Long id;
    private String name;
    private Integer callNumber;
    private List<FrequencyEntryDTO> frequencies;
}
