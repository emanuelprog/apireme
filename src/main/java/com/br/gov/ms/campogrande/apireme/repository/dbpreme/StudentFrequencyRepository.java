package com.br.gov.ms.campogrande.apireme.repository.dbpreme;

import com.br.gov.ms.campogrande.apireme.model.dbpreme.StudentFrequency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentFrequencyRepository extends JpaRepository<StudentFrequency, Long> {
    List<StudentFrequency> findByStudentIdInAndFrequencyDateBetween(List<Long> studentIds, Date start, Date end);

    Optional<StudentFrequency> findByDiaryGradeIdAndStudentIdAndFrequencyDateAndClassTimeId(
            Long diaryGradeId,
            Long studentId,
            Date frequencyDate,
            Long classTimeId
    );
}
