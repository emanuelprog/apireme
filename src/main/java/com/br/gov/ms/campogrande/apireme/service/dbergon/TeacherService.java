package com.br.gov.ms.campogrande.apireme.service.dbergon;

import com.br.gov.ms.campogrande.apireme.model.dbergon.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();

    Teacher findByCPF(String cpf);
}
