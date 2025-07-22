package com.br.gov.ms.campogrande.apireme.repository.dbpreme;

import com.br.gov.ms.campogrande.apireme.model.dbpreme.SchoolCoordinator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolCoordinatorRepository extends JpaRepository<SchoolCoordinator, Long> {
    List<SchoolCoordinator> findSchoolsCoordinatorByEnrollment(String enrollment);
}
