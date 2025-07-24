package com.br.gov.ms.campogrande.apireme.repository.dbedu;

import com.br.gov.ms.campogrande.apireme.model.dbedu.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByYearAndSectorAndDescriptionGroupAndDescriptionGradeAndDescriptionShift(
            Long year, String sector, String group, String grade, String shift
    );
}
