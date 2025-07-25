package com.br.gov.ms.campogrande.apireme.mapper.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.FrequencyEntryDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.StudentFrequencySaveDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.StudentFrequency;
import org.mapstruct.Mapper;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface StudentFrequencySaveMapper {

    default List<StudentFrequencySaveDTO> toDTO(List<StudentFrequency> entities, Function<Long, String> acronymResolver) {
        Map<Long, List<StudentFrequency>> grouped = entities.stream()
                .collect(Collectors.groupingBy(StudentFrequency::getStudentId, LinkedHashMap::new, Collectors.toList()));

        return grouped.entrySet().stream()
                .map(entry -> {
                    Long studentId = entry.getKey();
                    List<FrequencyEntryDTO> entries = entry.getValue().stream().map(f -> {
                        FrequencyEntryDTO dto = new FrequencyEntryDTO();
                        dto.setId(f.getId());
                        dto.setClassTime(String.valueOf(f.getClassTimeId()));
                        dto.setDate(f.getFrequencyDate().toString());
                        dto.setValue(acronymResolver.apply(f.getFrequencyTypeId()));
                        return dto;
                    }).collect(Collectors.toList());

                    StudentFrequencySaveDTO dto = new StudentFrequencySaveDTO();
                    dto.setId(studentId);
                    dto.setFrequencies(entries);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}