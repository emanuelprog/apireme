package com.br.gov.ms.campogrande.apireme.service.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.SubstituteTeacherDTO;

import java.util.List;

public interface SubstituteTeacherService {

    List<SubstituteTeacherDTO> findBySubstituteCPF(String cpf);
}
