package com.br.gov.ms.campogrande.apireme.service.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.StudentFrequencyDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.StudentFrequency;

import java.util.List;
import java.util.Map;

public interface FrequencyCellService {
    Map<String, StudentFrequencyDTO.FrequencyValueDTO> buildDefaultFrequencies(List<String> dateColumns, List<StudentFrequency> studentFrequencies);
    Map<String, Map<String, Boolean>> buildDefaultEditableMap(List<String> dateColumns, boolean hasOccurrence);
}
