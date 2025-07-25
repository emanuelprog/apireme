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
    private Boolean hasOccurrence;

    private Map<String, FrequencyCellDTO> frequencies;

    private Map<String, EditableFrequencyDTO> editableFrequencies;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class FrequencyCellDTO {
        private Long id;
        private String classTime;
        private String date;
        private String value;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class EditableFrequencyDTO {
        private Boolean editable;
        private Boolean observation;
    }
}