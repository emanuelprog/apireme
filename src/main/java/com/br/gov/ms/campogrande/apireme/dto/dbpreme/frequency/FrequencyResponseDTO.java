package com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FrequencyResponseDTO {
    private List<StudentFrequencyDTO> students;
    private List<String> dateColumns;
}
