package com.br.gov.ms.campogrande.apireme.repository.dbpreme;

import com.br.gov.ms.campogrande.apireme.model.dbpreme.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherScheduleRepository extends JpaRepository<TeacherSchedule, Long> {

    @Query("SELECT DISTINCT t.year FROM TeacherSchedule t " +
            "WHERE t.teachingType.id = :teachingTypeId " +
            "AND t.schoolNumber = :schoolNumber " +
            "AND t.enrollment = :enrollment")
    List<Long> findDistinctYears(Long teachingTypeId, Long schoolNumber, String enrollment);

    @Query("SELECT DISTINCT t.shift FROM TeacherSchedule t " +
            "WHERE t.teachingType.id = :teachingTypeId " +
            "AND t.schoolNumber = :schoolNumber " +
            "AND t.enrollment = :enrollment " +
            "AND t.year = :year")
    List<Shift> findDistinctShifts(Long teachingTypeId, Long schoolNumber, String enrollment, Long year);

    @Query("""
    SELECT t.id FROM TeacherSchedule t
    WHERE t.teachingType.id = :teachingTypeId
      AND t.schoolNumber = :schoolNumber
      AND t.enrollment = :enrollment
      AND t.year = :year
      AND t.shift.id = :shiftId
""")
    Optional<Long> findIdByParams(Long teachingTypeId, Long schoolNumber, String enrollment, Long year, Long shiftId);
}
