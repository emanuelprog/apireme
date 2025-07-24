package com.br.gov.ms.campogrande.apireme.service.dbergon;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.TeacherDTO;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    Optional<TeacherDTO> findByCPF(String cpf);
}
