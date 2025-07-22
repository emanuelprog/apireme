package com.br.gov.ms.campogrande.apireme.service.dbergon.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.SchoolDTO;
import com.br.gov.ms.campogrande.apireme.mapper.dbergon.SchoolMapper;
import com.br.gov.ms.campogrande.apireme.repository.dbergon.SchoolRepository;
import com.br.gov.ms.campogrande.apireme.service.dbergon.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    @Override
    public List<SchoolDTO> getSchoolsTeacher(String enrollment) {
        return schoolRepository.findSchoolsByEnrollment(enrollment)
                .stream()
                .map(schoolMapper::toDTO)
                .toList();
    }
}
