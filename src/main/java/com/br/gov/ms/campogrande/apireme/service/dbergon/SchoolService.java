package com.br.gov.ms.campogrande.apireme.service.dbergon;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.SchoolDTO;

import java.util.List;

public interface SchoolService {
    List<SchoolDTO> getSchoolsTeacher(String enrollment);
}
