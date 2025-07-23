package com.br.gov.ms.campogrande.apireme.service;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.SchoolDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.*;

import java.util.List;

public interface FilterService {

    List<TeachingTypeDTO> findAllTeachingType();

    List<SchoolDTO> findSchoolsByEnrollment(String enrollment, Boolean isCoordinator);

    List<Long> findAllYear(Long teachingTypeId, Long schoolNumber, String enrollment);

    List<ShiftDTO> findAllShifts(Long teachingTypeId, Long schoolNumber, String enrollment, Long year);

    List<GroupDTO> findAllGroups(Long teachingTypeId, Long schoolNumber, String enrollment, Long year, Long shiftId);

    List<DisciplineDTO> findAllDisciplines(Long teachingTypeId, Long schoolNumber, String enrollment, Long year, Long shiftId, Long groupId);

    List<GradeDTO> findAllGrades(Long teachingTypeId, Long schoolNumber, String enrollment, Long year, Long shiftId, Long groupId, Long disciplineId);
}
