package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.SubstituteTeacherDTO;
import com.br.gov.ms.campogrande.apireme.exception.NotFoundException;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.SubstituteTeacherMapper;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.SubstituteTeacher;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.SubstituteTeacherRepository;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.SubstituteTeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubstituteTeacherServiceImpl implements SubstituteTeacherService {

    private final SubstituteTeacherRepository substituteTeacherRepository;
    private final SubstituteTeacherMapper substituteTeacherMapper;

    @Override
    public List<SubstituteTeacherDTO> findByHolderCPF(String cpf) {
        return substituteTeacherRepository.findAllByHolderCPF(cpf).stream()
                .map(substituteTeacherMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SubstituteTeacherDTO findBySubstituteCPF(String cpf) {
        return substituteTeacherMapper.toDTO(substituteTeacherRepository.findBySubstituteCPF(cpf));
    }
}
