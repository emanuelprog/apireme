package com.br.gov.ms.campogrande.apireme.service.dbpreme;

import java.time.DayOfWeek;
import java.util.Map;
import java.util.Set;

public interface ScheduleService {
    Map<DayOfWeek, Set<Long>> getClassTimesByDay(Long teacherScheduleId, Long disciplineId,
                                                 String group, String grade, String shiftDesc);
}
