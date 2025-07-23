package com.br.gov.ms.campogrande.apireme.repository.dbpreme;

import com.br.gov.ms.campogrande.apireme.model.dbpreme.DiaryGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryGradeRepository extends JpaRepository<DiaryGrade, Long> {

    @Query("""
        SELECT d FROM DiaryGrade d
        WHERE (:enrollment IS NULL OR d.enrollment = :enrollment)
          AND (:teachingTypeId IS NULL OR d.teachingType.id = :teachingTypeId)
          AND (:sector IS NULL OR d.sector = :sector)
          AND (:shiftId IS NULL OR d.shift.id = :shiftId)
          AND (:groupId IS NULL OR d.group.id = :groupId)
          AND (:disciplineId IS NULL OR d.discipline.id = :disciplineId)
          AND (:gradeId IS NULL OR d.grade.id = :gradeId)
          AND (:bimester IS NULL OR d.bimesterPeriod.bimester = :bimester)
          AND (:year IS NULL OR EXTRACT(YEAR FROM d.createdAt) = :year)
    """)
    List<DiaryGrade> findFiltered(
            @Param("enrollment") String enrollment,
            @Param("teachingTypeId") Long teachingTypeId,
            @Param("sector") String sector,
            @Param("year") Long year,
            @Param("shiftId") Long shiftId,
            @Param("groupId") Long groupId,
            @Param("disciplineId") Long disciplineId,
            @Param("gradeId") Long gradeId,
            @Param("bimester") Long bimester
    );
}