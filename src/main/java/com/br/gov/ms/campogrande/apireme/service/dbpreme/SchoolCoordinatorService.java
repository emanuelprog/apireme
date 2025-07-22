package com.br.gov.ms.campogrande.apireme.service.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.SchoolDTO;

import java.util.List;

public interface SchoolCoordinatorService {
    List<SchoolDTO> getSchoolsCoordinator(String enrollment);
}
