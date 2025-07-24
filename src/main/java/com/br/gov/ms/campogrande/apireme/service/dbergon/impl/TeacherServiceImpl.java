package com.br.gov.ms.campogrande.apireme.service.dbergon.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.TeacherDTO;
import com.br.gov.ms.campogrande.apireme.mapper.dbergon.TeacherMapper;
import com.br.gov.ms.campogrande.apireme.repository.dbergon.TeacherRepository;
import com.br.gov.ms.campogrande.apireme.service.dbergon.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public Optional<TeacherDTO> findByCPF(String cpf) {
        return teacherRepository.findByCpf(cpf)
                .map(teacherMapper::toDTO);
    }
}