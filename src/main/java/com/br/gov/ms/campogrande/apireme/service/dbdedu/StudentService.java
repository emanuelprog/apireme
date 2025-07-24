package com.br.gov.ms.campogrande.apireme.service.dbdedu;

import com.br.gov.ms.campogrande.apireme.model.dbedu.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudentsByParams(String sector, String group, String grade, String shift, Long year);
}
