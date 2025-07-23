package com.br.gov.ms.campogrande.apireme.service.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.SchoolDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.*;
import com.br.gov.ms.campogrande.apireme.exception.NotFoundException;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.*;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.ScheduleRepository;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.TeacherScheduleRepository;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.TeachingTypeRepository;
import com.br.gov.ms.campogrande.apireme.service.FilterService;
import com.br.gov.ms.campogrande.apireme.service.dbergon.SchoolService;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.SchoolCoordinatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {

    private final TeacherScheduleRepository teacherScheduleRepository;
    private final TeachingTypeRepository teachingTypeRepository;
    private final ScheduleRepository scheduleRepository;

    private final SchoolCoordinatorService schoolCoordinatorService;
    private final SchoolService schoolService;

    private final TeachingTypeMapper teachingTypeMapper;
    private final DisciplineMapper disciplineMapper;
    private final ShiftMapper shiftMapper;
    private final GroupMapper groupMapper;
    private final GradeMapper gradeMapper;

    @Override
    public List<TeachingTypeDTO> findAllTeachingType() {
        return teachingTypeRepository.findAll().stream().map(teachingTypeMapper::toDTO).toList();
    }

    @Override
    public List<SchoolDTO> findSchoolsByEnrollment(String enrollment, Boolean isCoordinator) {
        if (isCoordinator) return schoolCoordinatorService.getSchoolsCoordinator(enrollment);

        return schoolService.getSchoolsTeacher(enrollment);
    }

    @Override
    public List<Long> findAllYear(Long teachingTypeId, Long schoolNumber, String enrollment) {
        return teacherScheduleRepository.findDistinctYears(teachingTypeId, schoolNumber, enrollment);
    }

    @Override
    public List<ShiftDTO> findAllShifts(Long teachingTypeId, Long schoolNumber, String enrollment, Long year) {
        return teacherScheduleRepository.findDistinctShifts(teachingTypeId, schoolNumber, enrollment, year).stream().map(shiftMapper::toDTO).toList();
    }

    @Override
    public List<GroupDTO> findAllGroups(Long teachingTypeId, Long schoolNumber, String enrollment, Long year, Long shiftId) {
        Long teacherScheduleId = teacherScheduleRepository.findIdByParams(teachingTypeId, schoolNumber, enrollment, year, shiftId)
                .orElseThrow(() -> new NotFoundException("TeacherSchedule não encontrado"));

        return scheduleRepository.findDistinctGroupsByTeacherSchedule(teacherScheduleId).stream()
                .map(groupMapper::toDTO)
                .sorted(Comparator.comparing(GroupDTO::getId))
                .toList();
    }

    @Override
    public List<DisciplineDTO> findAllDisciplines(Long teachingTypeId, Long schoolNumber, String enrollment, Long year, Long shiftId, Long groupId) {
        Long teacherScheduleId = teacherScheduleRepository.findIdByParams(teachingTypeId, schoolNumber, enrollment, year, shiftId)
                .orElseThrow(() -> new NotFoundException("TeacherSchedule não encontrado"));

        return scheduleRepository.findDistinctDisciplinesByTeacherSchedule(teacherScheduleId).stream()
                .map(disciplineMapper::toDTO)
                .sorted(Comparator.comparing(DisciplineDTO::getId))
                .toList();
    }

    @Override
    public List<GradeDTO> findAllGrades(Long teachingTypeId, Long schoolNumber, String enrollment, Long year, Long shiftId, Long groupId, Long disciplineId) {
        Long teacherScheduleId = teacherScheduleRepository.findIdByParams(teachingTypeId, schoolNumber, enrollment, year, shiftId)
                .orElseThrow(() -> new NotFoundException("TeacherSchedule não encontrado"));

        return scheduleRepository.findDistinctGradesByTeacherSchedule(teacherScheduleId).stream()
                .map(gradeMapper::toDTO)
                .sorted(Comparator.comparing(GradeDTO::getId))
                .toList();
    }
}
