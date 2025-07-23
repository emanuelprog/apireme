package com.br.gov.ms.campogrande.apireme.repository.dbpreme;

import com.br.gov.ms.campogrande.apireme.model.dbpreme.BimesterPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BimesterPeriodRepository extends JpaRepository<BimesterPeriod, Long> {

    @Query("""
    SELECT p.id
    FROM BimesterPeriod p
    WHERE p.bimester = :bimester
    AND EXTRACT(YEAR FROM p.startDate) = :year
    """)
    Optional<Long> findBimesterPeriodId(@Param("bimester") Long bimester, @Param("year") Long year);

}
