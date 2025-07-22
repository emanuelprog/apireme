package com.br.gov.ms.campogrande.apireme.service.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.SchoolDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.TeachingTypeDTO;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.TeachingTypeMapper;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.TeachingTypeRepository;
import com.br.gov.ms.campogrande.apireme.service.FilterService;
import com.br.gov.ms.campogrande.apireme.service.dbergon.SchoolService;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.SchoolCoordinatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {

    private final TeachingTypeRepository teachingTypeRepository;
    private final TeachingTypeMapper teachingTypeMapper;

    private final SchoolCoordinatorService schoolCoordinatorService;
    private final SchoolService schoolService;

    @Override
    public List<TeachingTypeDTO> findAllTeachingType() {
        return teachingTypeRepository.findAll().stream().map(teachingTypeMapper::toDTO).toList();
    }

    @Override
    public List<SchoolDTO> findSchoolsByEnrollment(String enrollment, Boolean isCoordinator) {
        if (isCoordinator) return schoolCoordinatorService.getSchoolsCoordinator(enrollment);

        return schoolService.getSchoolsTeacher(enrollment);
    }

    @Override
    public List<Long> findAllYear(Long teachingTypeId, String sector, String enrollment) {
        return List.of();
    }
}
