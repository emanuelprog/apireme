package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.SubstituteTeacherDTO;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.SubstituteTeacherMapper;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.SubstituteTeacherRepository;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.SubstituteTeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<SubstituteTeacherDTO> findBySubstituteCPF(String cpf) {
        return substituteTeacherRepository.findAllBySubstituteCPF(cpf).stream()
                .map(substituteTeacherMapper::toDTO)
                .collect(Collectors.toList());
    }
}
