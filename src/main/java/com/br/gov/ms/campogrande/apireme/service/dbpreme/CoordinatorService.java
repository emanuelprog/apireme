package com.br.gov.ms.campogrande.apireme.service.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.CoordinatorDTO;

import java.util.Optional;

public interface CoordinatorService {

    Optional<CoordinatorDTO> findByCPF(String cpf);
}
