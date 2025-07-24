package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.model.dbpreme.*;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.ScheduleRepository;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.ShiftRepository;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ShiftRepository shiftRepository;

    @Override
    public Map<DayOfWeek, Set<Long>> getClassTimesByDay(Long teacherScheduleId, Long disciplineId,
                                                        String group, String grade, String shiftDesc) {
        List<Schedule> schedules = scheduleRepository.findByTeacherScheduleId(teacherScheduleId);
        Shift shift = shiftRepository.findByDescription(shiftDesc);
        Map<DayOfWeek, Set<Long>> map = new HashMap<>();

        for (Schedule s : schedules) {
            Long ctId = s.getClassTimeId();
            if (!Objects.equals(s.getShiftId(), shift.getId())) continue;

            processDay(map, s.getMonday(), s.getMondayGroup(), s.getMondayGrade(), DayOfWeek.MONDAY, ctId, disciplineId, group, grade);
            processDay(map, s.getTuesday(), s.getTuesdayGroup(), s.getTuesdayGrade(), DayOfWeek.TUESDAY, ctId, disciplineId, group, grade);
            processDay(map, s.getWednesday(), s.getWednesdayGroup(), s.getWednesdayGrade(), DayOfWeek.WEDNESDAY, ctId, disciplineId, group, grade);
            processDay(map, s.getThursday(), s.getThursdayGroup(), s.getThursdayGrade(), DayOfWeek.THURSDAY, ctId, disciplineId, group, grade);
            processDay(map, s.getFriday(), s.getFridayGroup(), s.getFridayGrade(), DayOfWeek.FRIDAY, ctId, disciplineId, group, grade);
        }

        return map;
    }

    private void processDay(Map<DayOfWeek, Set<Long>> map, Discipline d, Group g, Grade gr,
                            DayOfWeek day, Long ctId, Long disciplineId, String group, String grade) {
        if (d != null && d.getId().equals(disciplineId)
                && g != null && g.getDescription().equals(group)
                && gr != null && gr.getDescription().equals(grade)) {
            map.computeIfAbsent(day, k -> new HashSet<>()).add(ctId);
        }
    }
}