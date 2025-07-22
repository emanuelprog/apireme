package com.br.gov.ms.campogrande.apireme.service;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.TeacherDTO;

import java.util.List;

public interface AuthService {

    List<TeacherDTO> authenticate(String token);
}
