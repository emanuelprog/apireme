package com.br.gov.ms.campogrande.apireme.service.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.StudentFrequencyDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.HistoryFrequency;

import java.util.List;
import java.util.Map;

public interface ObservationService {
    void applyObservationsFrequency(List<HistoryFrequency> histories, List<String> dateColumns,
                           Map<String, StudentFrequencyDTO.FrequencyValueDTO> frequencies,
                           Map<String, Map<String, Boolean>> editableMap);
}
