package com.br.gov.ms.campogrande.apireme.repository.dbergon;

import com.br.gov.ms.campogrande.apireme.model.dbergon.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, String> {

    @Query("""
    SELECT s
    FROM School s
    LEFT JOIN FETCH s.schoolSector
    WHERE s.enrollment = :enrollment
    """)
    List<School> findSchoolsByEnrollment(@Param("enrollment") String enrollment);
}
