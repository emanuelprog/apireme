package com.br.gov.ms.campogrande.apireme.service.dbdedu.impl;

import com.br.gov.ms.campogrande.apireme.model.dbedu.Student;
import com.br.gov.ms.campogrande.apireme.repository.dbedu.StudentRepository;
import com.br.gov.ms.campogrande.apireme.service.dbdedu.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudentsByParams(String sector, String group, String grade, String shift, Long year) {
        return studentRepository.findByYearAndSectorAndDescriptionGroupAndDescriptionGradeAndDescriptionShift(year, sector, group, grade, shift);
    }
}
