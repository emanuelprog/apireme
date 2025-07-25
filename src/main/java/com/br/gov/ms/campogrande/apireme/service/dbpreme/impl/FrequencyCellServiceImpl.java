package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.StudentFrequencyDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.StudentFrequency;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.FrequencyCellService;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.FrequencyTypeService;
import com.br.gov.ms.campogrande.apireme.util.FrequencyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FrequencyCellServiceImpl implements FrequencyCellService {

    private final FrequencyTypeService frequencyTypeService;

    @Override
    public Map<String, StudentFrequencyDTO.FrequencyValueDTO> buildDefaultFrequencies(List<String> dateColumns, List<StudentFrequency> studentFrequencies) {
        Map<String, StudentFrequency> frequencyByKey = studentFrequencies.stream()
                .collect(Collectors.toMap(
                        f -> FrequencyUtil.formatDateKey(f.getClassTimeId(), f.getFrequencyDate()),
                        f -> f,
                        (a, b) -> b
                ));

        return dateColumns.stream()
                .collect(Collectors.toMap(
                        d -> d,
                        d -> {
                            StudentFrequency freq = frequencyByKey.get(d);
                            if (freq != null) {
                                String value = frequencyTypeService.resolveAcronym(freq.getFrequencyTypeId());
                                return StudentFrequencyDTO.FrequencyValueDTO.builder()
                                        .id(freq.getId())
                                        .value(value)
                                        .build();
                            } else {
                                return StudentFrequencyDTO.FrequencyValueDTO.builder()
                                        .id(null)
                                        .value("")
                                        .build();
                            }
                        },
                        (a, b) -> b,
                        LinkedHashMap::new
                ));
    }

    @Override
    public Map<String, Map<String, Boolean>> buildDefaultEditableMap(List<String> dateColumns, boolean hasOccurrence) {
        return dateColumns.stream()
                .collect(Collectors.toMap(
                        d -> d,
                        d -> FrequencyUtil.buildCellInfo(hasOccurrence, false)
                ));
    }
}

