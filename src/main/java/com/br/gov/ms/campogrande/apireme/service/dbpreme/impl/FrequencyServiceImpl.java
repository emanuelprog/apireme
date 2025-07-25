package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.diary.DiaryGradeDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.FrequencyRequestDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.FrequencyResponseDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.StudentFrequencyDTO;
import com.br.gov.ms.campogrande.apireme.model.dbedu.Student;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.StudentFrequency;
import com.br.gov.ms.campogrande.apireme.service.dbdedu.StudentService;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FrequencyServiceImpl implements FrequencyService {

    private final StudentService studentService;
    private final StudentFrequencyService studentFrequencyService;
    private final ScheduleService scheduleService;
    private final DateColumnService dateColumnService;
    private final DiaryGradeService diaryGradeService;

    @Override
    public FrequencyResponseDTO getFrequencyResponse(Long teacherScheduleId, Long disciplineId, String sector, String group, String grade, String shift, Long year, Date from, Date to) {
        List<Student> students = studentService.findAllStudentsByParams(sector, group, grade, shift, year);
        List<Long> studentIds = students.stream().map(Student::getId).collect(Collectors.toList());

        List<StudentFrequency> frequencies = studentFrequencyService.findByParams(studentIds, from, to);
        Map<Long, List<StudentFrequency>> frequencyByStudent = frequencies.stream().collect(Collectors.groupingBy(StudentFrequency::getStudentId));

        Map<DayOfWeek, Set<Long>> classTimesByDay = scheduleService.getClassTimesByDay(teacherScheduleId, disciplineId, group, grade, shift);
        List<String> dateColumns = dateColumnService.generateDateColumns(from, to, classTimesByDay);

        List<StudentFrequencyDTO> studentDTOs = studentFrequencyService.buildStudentFrequencyDTOs(students, dateColumns, frequencyByStudent);

        return new FrequencyResponseDTO(studentDTOs, dateColumns, null);
    }

    @Transactional
    @Override
    public Long saveFrequencies(FrequencyRequestDTO frequencyRequestDTO) {
        DiaryGradeDTO savedDiaryGrade = diaryGradeService.save(frequencyRequestDTO.getDiaryGrade());

        studentFrequencyService.saveStudentFrequencies(
                frequencyRequestDTO.getStudentsFrequency(), savedDiaryGrade.getId(), savedDiaryGrade.getChangeUser()
        );

        return savedDiaryGrade.getId();
    }
}
