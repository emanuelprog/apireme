package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.StudentFrequencyDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.HistoryFrequency;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.ObservationService;
import com.br.gov.ms.campogrande.apireme.util.DateUtil;
import com.br.gov.ms.campogrande.apireme.util.FrequencyUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@Service
public class ObservationServiceImpl implements ObservationService {

    @Override
    public void applyObservationsFrequency(List<HistoryFrequency> histories,
                                           List<String> dateColumns,
                                           Map<String, StudentFrequencyDTO.FrequencyValueDTO> freqMap,
                                           Map<String, Map<String, Boolean>> editableMap) {
        for (HistoryFrequency history : histories) {
            LocalDate start = DateUtil.convertToLocalDate(history.getStartDate());
            LocalDate end = DateUtil.convertToLocalDate(history.getEndDate());
            long days = ChronoUnit.DAYS.between(start, end) + 1;
            String mark = days <= 3 ? "F" : "-";

            for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
                String formatted = date.format(DateTimeFormatter.ofPattern("dd/MM"));
                for (String column : dateColumns) {
                    if (column.endsWith(formatted)) {
                        if (freqMap.containsKey(column)) {
                            freqMap.get(column).setValue(mark);
                        } else {
                            freqMap.put(column, StudentFrequencyDTO.FrequencyValueDTO.builder()
                                    .id(null)
                                    .value(mark)
                                    .build());
                        }

                        editableMap.put(column, FrequencyUtil.buildCellInfo(false, true));
                    }
                }
            }
        }
    }
}
