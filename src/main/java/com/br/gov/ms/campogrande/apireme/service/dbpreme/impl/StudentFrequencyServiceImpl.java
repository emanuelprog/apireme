package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.StudentFrequencyDTO;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.StudentFrequencyMapper;
import com.br.gov.ms.campogrande.apireme.model.dbedu.Student;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.StudentFrequency;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.StudentFrequencyRepository;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.FrequencyCellService;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.FrequencyTypeService;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.StudentFrequencyService;
import com.br.gov.ms.campogrande.apireme.util.DateUtil;
import com.br.gov.ms.campogrande.apireme.util.FrequencyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentFrequencyServiceImpl implements StudentFrequencyService {

    private final StudentFrequencyRepository studentFrequencyRepository;
    private final FrequencyTypeService frequencyTypeService;
    private final FrequencyCellService frequencyCellService;
    private final StudentFrequencyMapper studentFrequencyMapper;

    @Override
    public List<StudentFrequency> findByParams(List<Long> studentIds, Date from, Date to) {
        return studentFrequencyRepository.findByStudentIdInAndFrequencyDateBetween(studentIds, from, to);
    }

    @Override
    public List<StudentFrequencyDTO> buildStudentFrequencyDTOs(
            List<Student> students,
            List<String> dateColumns,
            Map<Long, List<StudentFrequency>> frequencyMap
    ) {
        return students.stream().map(student -> {
            StudentFrequencyDTO dto = new StudentFrequencyDTO();
            dto.setId(student.getId());
            dto.setCallNumber(student.getCallNumber());

            if (student.getOccurrenceId() != null && student.getOccurrenceId() != 1
                    && student.getOccurrenceType() != null && student.getOccurrenceDate() != null) {
                String date = new SimpleDateFormat("dd/MM").format(student.getOccurrenceDate());
                dto.setName(student.getName() + " (" + student.getOccurrenceType() + " - " + date + ")");
                dto.setHasOccurrence(true);
            } else {
                dto.setName(student.getName());
            }

            boolean hasOccurrence = student.getOccurrenceId() == 1;

            List<StudentFrequency> studentFrequencies = frequencyMap.getOrDefault(student.getId(), Collections.emptyList());

            Map<String, StudentFrequencyDTO.FrequencyCellDTO> frequencies =
                    frequencyCellService.buildDefaultFrequencies(dateColumns, studentFrequencies);
            Map<String, StudentFrequencyDTO.EditableFrequencyDTO> editableMap =
                    frequencyCellService.buildDefaultEditableMap(dateColumns, hasOccurrence);

            for (StudentFrequency freq : studentFrequencies) {
                String key = FrequencyUtil.formatDateKey(freq.getClassTimeId(), freq.getFrequencyDate());
                String acronym = frequencyTypeService.resolveAcronym(freq.getFrequencyTypeId());

                if (frequencies.containsKey(key)) {
                    StudentFrequencyDTO.FrequencyCellDTO cell = frequencies.get(key);
                    cell.setId(freq.getId());
                    cell.setValue(acronym);
                } else {
                    frequencies.put(key, StudentFrequencyDTO.FrequencyCellDTO.builder()
                            .id(freq.getId())
                            .classTime(String.valueOf(freq.getClassTimeId()))
                            .date(DateUtil.formatDate(freq.getFrequencyDate()))
                            .value(acronym)
                            .build()
                    );
                }

                editableMap.put(key, StudentFrequencyDTO.EditableFrequencyDTO.builder()
                        .editable(!"-".equals(acronym) && hasOccurrence)
                        .observation(false)
                        .build()
                );
            }

            dto.setFrequencies(frequencies);
            dto.setEditableFrequencies(editableMap);

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void saveStudentFrequencies(List<StudentFrequencyDTO> studentFrequencyDTOS, Long diaryGradeId, String changeUser) {
        studentFrequencyRepository.saveAll(studentFrequencyMapper.toModelList(studentFrequencyDTOS, diaryGradeId, changeUser));
    }
}