package com.br.gov.ms.campogrande.apireme.repository.dbpreme;

import com.br.gov.ms.campogrande.apireme.model.dbpreme.Discipline;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.Grade;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.Group;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("""
    SELECT DISTINCT h.mondayGroup FROM Schedule h WHERE h.teacherScheduleId = :teacherScheduleId AND h.mondayGroup IS NOT NULL
    UNION
    SELECT DISTINCT h.tuesdayGroup FROM Schedule h WHERE h.teacherScheduleId = :teacherScheduleId AND h.tuesdayGroup IS NOT NULL
    UNION
    SELECT DISTINCT h.wednesdayGroup FROM Schedule h WHERE h.teacherScheduleId = :teacherScheduleId AND h.wednesdayGroup IS NOT NULL
    UNION
    SELECT DISTINCT h.thursdayGroup FROM Schedule h WHERE h.teacherScheduleId = :teacherScheduleId AND h.thursdayGroup IS NOT NULL
    UNION
    SELECT DISTINCT h.fridayGroup FROM Schedule h WHERE h.teacherScheduleId = :teacherScheduleId AND h.fridayGroup IS NOT NULL
""")
    List<Group> findDistinctGroupsByTeacherSchedule(Long teacherScheduleId);

    @Query("""
    SELECT DISTINCT h.monday FROM Schedule h WHERE h.teacherScheduleId = :teacherScheduleId AND h.monday IS NOT NULL
    UNION
    SELECT DISTINCT h.tuesday FROM Schedule h WHERE h.teacherScheduleId = :teacherScheduleId AND h.tuesday IS NOT NULL
    UNION
    SELECT DISTINCT h.wednesday FROM Schedule h WHERE h.teacherScheduleId = :teacherScheduleId AND h.wednesday IS NOT NULL
    UNION
    SELECT DISTINCT h.thursday FROM Schedule h WHERE h.teacherScheduleId = :teacherScheduleId AND h.thursday IS NOT NULL
    UNION
    SELECT DISTINCT h.friday FROM Schedule h WHERE h.teacherScheduleId = :teacherScheduleId AND h.friday IS NOT NULL
""")
    List<Discipline> findDistinctDisciplinesByTeacherSchedule(Long teacherScheduleId);

    @Query("""
    SELECT DISTINCT h.mondayGrade FROM Schedule h WHERE h.teacherScheduleId = :teacherScheduleId AND h.mondayGrade IS NOT NULL
    UNION
    SELECT DISTINCT h.tuesdayGrade FROM Schedule h WHERE h.teacherScheduleId = :teacherScheduleId AND h.tuesdayGrade IS NOT NULL
    UNION
    SELECT DISTINCT h.wednesdayGrade FROM Schedule h WHERE h.teacherScheduleId = :teacherScheduleId AND h.wednesdayGrade IS NOT NULL
    UNION
    SELECT DISTINCT h.thursdayGrade FROM Schedule h WHERE h.teacherScheduleId = :teacherScheduleId AND h.thursdayGrade IS NOT NULL
    UNION
    SELECT DISTINCT h.fridayGrade FROM Schedule h WHERE h.teacherScheduleId = :teacherScheduleId AND h.fridayGrade IS NOT NULL
""")
    List<Grade> findDistinctGradesByTeacherSchedule(Long teacherScheduleId);

    List<Schedule> findByTeacherScheduleId(Long teacherScheduleId);
}
