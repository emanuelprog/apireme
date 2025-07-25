package com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
public class StudentFrequencyDTO {
    private Long id;
    private String name;
    private Long callNumber;
    private Boolean hasObservation;
    private Boolean hasOccurrence;
    private Map<String, FrequencyValueDTO> frequencies;
    private Map<String, Map<String, Boolean>> editableFrequencies;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class FrequencyValueDTO {
        private String value;
        private Long id;
    }
}
