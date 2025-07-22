package com.br.gov.ms.campogrande.apireme.repository.dbergon;

import com.br.gov.ms.campogrande.apireme.model.dbergon.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, String> {
    List<School> findSchoolsByEnrollment(String enrollment);
}
