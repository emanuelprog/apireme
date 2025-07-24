package com.br.gov.ms.campogrande.apireme.repository.dbpreme;

import com.br.gov.ms.campogrande.apireme.model.dbpreme.HistoryFrequency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryFrequencyRepository extends JpaRepository<HistoryFrequency, Long> {

    List<HistoryFrequency> findByStudentId(Long studentId);
}
