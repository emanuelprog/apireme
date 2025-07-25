package com.br.gov.ms.campogrande.apireme.mapper.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.FrequencyEntryDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.StudentFrequencyDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.StudentFrequency;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.StudentFrequencySaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Date;

@Mapper(componentModel = "spring")
public interface StudentFrequencyMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "diaryGradeId", source = "diaryGradeId")
    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "studentName", source = "student.name")
    @Mapping(target = "callNumber", source = "student.callNumber")
    @Mapping(target = "frequencyDate", expression = "java(parseDate(entry.getDate()))")
    @Mapping(target = "classTimeId", expression = "java(parseClassTime(entry.getClassTime()))")
    @Mapping(target = "frequencyTypeId", expression = "java(parseFrequencyValue(entry.getValue()))")
    @Mapping(target = "changeUser", source = "changeUser")
    StudentFrequency toModel(FrequencyEntryDTO entry, StudentFrequencySaveDTO student, Long diaryGradeId, String changeUser);

    StudentFrequencyDTO toDTO(StudentFrequency model);

    default Long parseClassTime(String classTime) {
        try {
            return Long.parseLong(classTime);
        } catch (Exception e) {
            return null;
        }
    }

    default Long parseFrequencyValue(String value) {
        if ("F".equals(value)) return 1L;
        if (".".equals(value)) return 2L;
        if ("-".equals(value)) return 3L;
        return null;
    }

    default Date parseDate(String dateStr) {
        try {
            return java.sql.Date.valueOf(dateStr);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter data: " + dateStr, e);
        }
    }
}