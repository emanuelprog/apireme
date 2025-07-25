package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.StudentFrequencyDTO;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.StudentFrequencyMapper;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.StudentFrequencySaveMapper;
import com.br.gov.ms.campogrande.apireme.model.dbedu.Student;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.HistoryFrequency;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.StudentFrequency;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.StudentFrequencySaveDTO;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.HistoryFrequencyRepository;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.StudentFrequencyRepository;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.FrequencyCellService;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.FrequencyTypeService;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.ObservationService;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.StudentFrequencyService;
import com.br.gov.ms.campogrande.apireme.util.FrequencyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentFrequencyServiceImpl implements StudentFrequencyService {

    private final StudentFrequencyRepository studentFrequencyRepository;
    private final HistoryFrequencyRepository historyFrequencyRepository;
    private final FrequencyTypeService frequencyTypeService;
    private final ObservationService observationService;
    private final FrequencyCellService frequencyCellService;
    private final StudentFrequencyMapper studentFrequencyMapper;
    private final StudentFrequencySaveMapper studentFrequencySaveMapper;

    @Override
    public List<StudentFrequency> findByParams(List<Long> studentIds, Date from, Date to) {
        return studentFrequencyRepository.findByStudentIdInAndFrequencyDateBetween(studentIds, from, to);
    }

    @Override
    public List<StudentFrequencyDTO> buildStudentFrequencyDTOs(List<Student> students, List<String> dateColumns, Map<Long, List<StudentFrequency>> frequencyMap) {
        return students.stream().map(student -> {
            StudentFrequencyDTO dto = new StudentFrequencyDTO();
            dto.setId(student.getId());
            dto.setCallNumber(student.getCallNumber());

            if (student.getOccurrenceId() != null && student.getOccurrenceId() != 1 && student.getOccurrenceType() != null && student.getOccurrenceDate() != null) {
                String date = new SimpleDateFormat("dd/MM").format(student.getOccurrenceDate());
                dto.setName(student.getName() + " (" + student.getOccurrenceType() + " - " + date + ")");
                dto.setHasOccurrence(true);
            } else {
                dto.setName(student.getName());
            }

            List<HistoryFrequency> histories = historyFrequencyRepository.findByStudentId(student.getId());
            dto.setHasObservation(!histories.isEmpty());

            boolean hasOccurrence = student.getOccurrenceId() == 1;

            List<StudentFrequency> studentFrequencies = frequencyMap.getOrDefault(student.getId(), Collections.emptyList());
            Map<String, StudentFrequencyDTO.FrequencyValueDTO> frequencies = frequencyCellService.buildDefaultFrequencies(dateColumns, studentFrequencies);
            Map<String, Map<String, Boolean>> editableMap = frequencyCellService.buildDefaultEditableMap(dateColumns, hasOccurrence);

            for (StudentFrequency freq : frequencyMap.getOrDefault(student.getId(), Collections.emptyList())) {
                String key = FrequencyUtil.formatDateKey(freq.getClassTimeId(), freq.getFrequencyDate());
                String acronym = frequencyTypeService.resolveAcronym(freq.getFrequencyTypeId());

                if (frequencies.containsKey(key)) {
                    StudentFrequencyDTO.FrequencyValueDTO dtoValue = frequencies.get(key);
                    dtoValue.setValue(acronym);
                    dtoValue.setId(freq.getId());
                } else {
                    frequencies.put(key, StudentFrequencyDTO.FrequencyValueDTO.builder()
                            .id(freq.getId())
                            .value(acronym)
                            .build());
                }

                editableMap.put(key, FrequencyUtil.buildCellInfo(!"-".equals(acronym) && hasOccurrence, false));
            }

            if (student.getOccurrenceId() == 1) {
                observationService.applyObservationsFrequency(histories, dateColumns, frequencies, editableMap);
            }

            dto.setFrequencies(frequencies);
            dto.setEditableFrequencies(editableMap);

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<StudentFrequencySaveDTO> saveStudentFrequencies(List<StudentFrequencySaveDTO> frequencies, Long diaryGradeId, String changeUser) {
        List<StudentFrequency> entities = frequencies.stream()
                .flatMap(student -> student.getFrequencies().stream()
                        .map(entry -> {
                            StudentFrequency entity = studentFrequencyMapper.toModel(entry, student, diaryGradeId, changeUser);

                            if (entry.getId() != null) {
                                entity.setId(entry.getId());
                            }

                            return entity;
                        })
                )
                .collect(Collectors.toList());

        List<StudentFrequency> saved = studentFrequencyRepository.saveAll(entities);

        return studentFrequencySaveMapper.toDTO(saved,
                frequencyTypeService::resolveAcronym
        );
    }
}