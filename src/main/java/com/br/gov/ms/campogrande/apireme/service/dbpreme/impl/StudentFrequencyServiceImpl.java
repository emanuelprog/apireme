package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.StudentFrequencyDTO;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.StudentFrequencyMapper;
import com.br.gov.ms.campogrande.apireme.model.dbedu.Student;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.HistoryFrequency;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.StudentFrequency;
import com.br.gov.ms.campogrande.apireme.payload.StudentFrequencyPayload;
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

    @Override
    public List<StudentFrequency> findByParams(List<Long> studentIds, Date from, Date to) {
        return studentFrequencyRepository.findByStudentIdInAndFrequencyDateBetween(studentIds, from, to);
    }

    @Override
    public List<StudentFrequencyDTO> buildStudentFrequencyDTOs(List<Student> students,
                                                               List<String> dateColumns,
                                                               Map<Long, List<StudentFrequency>> frequencyMap) {
        return students.stream().map(student -> {
            StudentFrequencyDTO dto = new StudentFrequencyDTO();
            dto.setId(student.getId());
            dto.setCallNumber(student.getCallNumber());

            if (student.getOccurrenceId() != null && student.getOccurrenceType() != null && student.getOccurrenceDate() != null) {
                String date = new SimpleDateFormat("dd/MM").format(student.getOccurrenceDate());
                dto.setName(student.getName() + " (" + student.getOccurrenceType() + " - " + date + ")");
                dto.setHasOccurrence(true);
            } else {
                dto.setName(student.getName());
            }

            List<HistoryFrequency> histories = historyFrequencyRepository.findByStudentId(student.getId());
            dto.setHasObservation(!histories.isEmpty());

            boolean hasOccurrence = student.getOccurrenceId() == 1;

            Map<String, String> frequencies = frequencyCellService.buildDefaultFrequencies(dateColumns, hasOccurrence);
            Map<String, Map<String, Boolean>> editableMap = frequencyCellService.buildDefaultEditableMap(dateColumns, hasOccurrence);

            for (StudentFrequency freq : frequencyMap.getOrDefault(student.getId(), Collections.emptyList())) {
                String key = FrequencyUtil.formatDateKey(freq.getClassTimeId(), freq.getFrequencyDate());
                String acronym = frequencyTypeService.resolveAcronym(freq.getFrequencyTypeId());
                frequencies.put(key, acronym);
                editableMap.put(key, FrequencyUtil.buildCellInfo(!"-".equals(acronym) && hasOccurrence, false));
            }

            observationService.applyObservationsFrequency(histories, dateColumns, frequencies, editableMap);

            dto.setFrequencies(frequencies);
            dto.setEditableFrequencies(editableMap);

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void saveStudentFrequencies(List<StudentFrequencyPayload> frequencies, Long diaryGradeId, String changeUser) {
        List<StudentFrequency> entities = frequencies.stream()
                .flatMap(student -> student.getFrequencies().stream()
                        .map(entry -> {
                            StudentFrequency entity = studentFrequencyMapper.toModel(entry, student, diaryGradeId, changeUser);

                            Optional<StudentFrequency> existing = studentFrequencyRepository
                                    .findByDiaryGradeIdAndStudentIdAndFrequencyDateAndClassTimeId(
                                            diaryGradeId,
                                            student.getId(),
                                            entity.getFrequencyDate(),
                                            entity.getClassTimeId()
                                    );

                            existing.ifPresent(e -> entity.setId(e.getId()));

                            return entity;
                        })
                )
                .collect(Collectors.toList());

        studentFrequencyRepository.saveAll(entities);
    }
}