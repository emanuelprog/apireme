package com.br.gov.ms.campogrande.apireme.service;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.SchoolDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.TeachingTypeDTO;

import java.util.List;

public interface FilterService {

    List<TeachingTypeDTO> findAllTeachingType();

    List<SchoolDTO> findSchoolsByEnrollment(String enrollment, Boolean isCoordinator);

    List<Long> findAllYear(Long teachingTypeId, String sector, String enrollment);
}
