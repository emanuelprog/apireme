package com.br.gov.ms.campogrande.apireme.repository.dbpreme;

import com.br.gov.ms.campogrande.apireme.model.dbpreme.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoordinatorRepository extends JpaRepository<Coordinator, Long> {
    Optional<Coordinator> findByCpf(String cpf);
}