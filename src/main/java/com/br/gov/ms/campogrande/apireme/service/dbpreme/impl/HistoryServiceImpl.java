package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.HistoryFrequencyDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.StudentFrequencyDTO;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.HistoryFrequencyMapper;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.HistoryFrequencyRepository;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.HistoryService;
import com.br.gov.ms.campogrande.apireme.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryFrequencyRepository historyFrequencyRepository;
    private final HistoryFrequencyMapper historyFrequencyMapper;

    @Override
    public void applyHistoriesFrequency(
            List<HistoryFrequencyDTO> histories,
            List<String> dateColumns,
            Map<String, StudentFrequencyDTO.FrequencyCellDTO> freqMap,
            Map<String, StudentFrequencyDTO.EditableFrequencyDTO> editableMap
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (HistoryFrequencyDTO history : histories) {
            LocalDate start = DateUtil.convertToLocalDate(history.getStartDate());
            LocalDate end = DateUtil.convertToLocalDate(history.getEndDate());
            long days = ChronoUnit.DAYS.between(start, end) + 1;
            String mark = days <= 3 ? "F" : "-";

            for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
                String formatted = date.format(formatter);

                for (String column : dateColumns) {
                    if (column.endsWith(formatted)) {
                        StudentFrequencyDTO.FrequencyCellDTO cell = freqMap.getOrDefault(column,
                                StudentFrequencyDTO.FrequencyCellDTO.builder()
                                        .id(null)
                                        .classTime("")
                                        .date(date.toString())
                                        .value("")
                                        .build()
                        );

                        cell.setValue(mark);
                        freqMap.put(column, cell);

                        editableMap.put(column,
                                StudentFrequencyDTO.EditableFrequencyDTO.builder()
                                        .editable(false)
                                        .observation(true)
                                        .build()
                        );
                    }
                }
            }
        }
    }

    @Override
    public List<HistoryFrequencyDTO> findHistoriesFrequencyByStudent(Long studentId) {
        return historyFrequencyRepository.findAllByStudentId(studentId).stream().map(historyFrequencyMapper::toDTO).toList();
    }
}