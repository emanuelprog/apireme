package com.br.gov.ms.campogrande.apireme.service.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.HistoryFrequencyDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.StudentFrequencyDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.HistoryFrequency;

import java.util.List;
import java.util.Map;

public interface HistoryService {
    void applyHistoriesFrequency(
            List<HistoryFrequencyDTO> histories,
            List<String> dateColumns,
            Map<String, StudentFrequencyDTO.FrequencyCellDTO> frequencies,
            Map<String, StudentFrequencyDTO.EditableFrequencyDTO> editableMap
    );

    List<HistoryFrequencyDTO> findHistoriesFrequencyByStudent(Long studentId);
}
