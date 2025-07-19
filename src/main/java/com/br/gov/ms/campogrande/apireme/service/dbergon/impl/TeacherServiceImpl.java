package com.br.gov.ms.campogrande.apireme.service.dbergon.impl;

import com.br.gov.ms.campogrande.apireme.exception.NotFoundException;
import com.br.gov.ms.campogrande.apireme.model.dbergon.Teacher;
import com.br.gov.ms.campogrande.apireme.repository.dbergon.TeacherRepository;
import com.br.gov.ms.campogrande.apireme.service.dbergon.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findByCPF(String cpf) {
        return teacherRepository.findByCpf(cpf).orElseThrow(() -> new NotFoundException("Professor com CPF " + cpf + " não encontrado"));
    }
}