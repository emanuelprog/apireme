package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.SchoolDTO;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.SchoolCoordinatorMapper;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.SchoolCoordinatorRepository;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.SchoolCoordinatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolCoordinatorServiceImpl implements SchoolCoordinatorService {

    private final SchoolCoordinatorRepository schoolCoordinatorRepository;
    private final SchoolCoordinatorMapper schoolCoordinatorMapper;

    @Override
    public List<SchoolDTO> getSchoolsCoordinator(String enrollment) {
        return schoolCoordinatorRepository.findSchoolsCoordinatorByEnrollment(enrollment)
                .stream()
                .map(schoolCoordinatorMapper::toSchoolDTO)
                .toList();
    }
}
