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
    public Map<String, StudentFrequencyDTO.FrequencyCellDTO> buildDefaultFrequencies(
            List<String> dateColumns,
            List<StudentFrequency> studentFrequencies
    ) {
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
                            String[] parts = d.split(" - ");
                            String classTime = parts.length > 0 ? parts[0].trim() : "";
                            String formattedDate = parts.length > 1 ? parts[1].trim() : "";

                            StudentFrequency freq = frequencyByKey.get(d);

                            if (freq != null) {
                                String value = frequencyTypeService.resolveAcronym(freq.getFrequencyTypeId());
                                return StudentFrequencyDTO.FrequencyCellDTO.builder()
                                        .id(freq.getId())
                                        .classTime(classTime)
                                        .date(formattedDate)
                                        .value(value)
                                        .build();
                            } else {
                                return StudentFrequencyDTO.FrequencyCellDTO.builder()
                                        .id(null)
                                        .classTime(classTime)
                                        .date(formattedDate)
                                        .value("")
                                        .build();
                            }
                        },
                        (a, b) -> b,
                        LinkedHashMap::new
                ));
    }

    @Override
    public Map<String, StudentFrequencyDTO.EditableFrequencyDTO> buildDefaultEditableMap(
            List<String> dateColumns,
            boolean hasOccurrence
    ) {
        return dateColumns.stream()
                .collect(Collectors.toMap(
                        d -> d,
                        d -> StudentFrequencyDTO.EditableFrequencyDTO.builder()
                                .editable(hasOccurrence)
                                .observation(false)
                                .build()
                ));
    }
}

