package com.br.gov.ms.campogrande.apireme.dto.dbpreme;

import lombok.Data;

import java.util.Map;

@Data
public class StudentFrequencyDTO {
    private Long id;
    private String name;
    private Long callNumber;
    private Boolean hasObservation;
    private Boolean hasOccurrence;
    private Map<String, String> frequencies;
    private Map<String, Map<String, Boolean>> editableFrequencies;
}
