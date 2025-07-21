package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.CoordinatorDTO;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.CoordinatorMapper;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.CoordinatorRepository;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.CoordinatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoordinatorServiceImpl implements CoordinatorService {

    private final CoordinatorRepository coordinatorRepository;
    private final CoordinatorMapper coordinatorMapper;

    @Override
    public Optional<CoordinatorDTO> findByCPF(String cpf) {
        return coordinatorRepository.findByCpf(cpf)
                .map(coordinatorMapper::toDTO);
    }
}
