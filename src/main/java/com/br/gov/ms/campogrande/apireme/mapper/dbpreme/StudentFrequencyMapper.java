package com.br.gov.ms.campogrande.apireme.mapper.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.StudentFrequencyDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.StudentFrequency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface StudentFrequencyMapper {

    @Mapping(target = "id", source = "cellDTO.id")
    @Mapping(target = "diaryGradeId", source = "diaryGradeId")
    @Mapping(target = "studentId", source = "studentFrequencyDTO.id")
    @Mapping(target = "studentName", expression = "java(cleanName(studentFrequencyDTO.getName()))")
    @Mapping(target = "callNumber", source = "studentFrequencyDTO.callNumber")
    @Mapping(target = "frequencyDate", expression = "java(parseDate(cellDTO.getDate()))")
    @Mapping(target = "classTimeId", expression = "java(parseClassTime(cellDTO.getClassTime()))")
    @Mapping(target = "frequencyTypeId", expression = "java(parseFrequencyValue(cellDTO.getValue()))")
    @Mapping(target = "changeUser", source = "changeUser")
    StudentFrequency toModel(StudentFrequencyDTO.FrequencyCellDTO cellDTO, StudentFrequencyDTO studentFrequencyDTO, Long diaryGradeId, String changeUser);

    StudentFrequencyDTO toDTO(StudentFrequency model);

    default List<StudentFrequency> toModelList(
            List<StudentFrequencyDTO> studentFrequencyDTOS,
            Long diaryGradeId,
            String changeUser
    ) {
        if (studentFrequencyDTOS == null || studentFrequencyDTOS.isEmpty()) {
            return Collections.emptyList();
        }

        return studentFrequencyDTOS.stream()
                .filter(dto -> dto.getFrequencies() != null)
                .flatMap(studentFrequencyDTO -> studentFrequencyDTO.getFrequencies().values().stream()
                        .map(cellDTO -> toModel(cellDTO, studentFrequencyDTO, diaryGradeId, changeUser))
                )
                .collect(Collectors.toList());
    }

    @SuppressWarnings("unused")
    default Long parseClassTime(String classTime) {
        try {
            return Long.parseLong(classTime);
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings("unused")
    default Long parseFrequencyValue(String value) {
        if (".".equals(value)) return 1L;
        if ("F".equals(value)) return 2L;
        if ("-".equals(value)) return 3L;
        return null;
    }

    @SuppressWarnings("unused")
    default Date parseDate(String dateStr) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null;
        }

        String trimmed = dateStr.trim();

        if (trimmed.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return java.sql.Date.valueOf(trimmed);
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(trimmed, formatter);
            return java.sql.Date.valueOf(localDate);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter data: " + dateStr, e);
        }
    }


    default String cleanName(String name) {
        if (name == null) return null;
        return name.replaceAll("\\s*\\(.*?\\)", "").trim();
    }
}