package com.br.gov.ms.campogrande.apireme.service.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.DiaryGradeDTO;

import java.util.List;

public interface DiaryGradeService {
    List<DiaryGradeDTO> findByFilter(String enrollment, Long teachingTypeId, String sector, Long year, Long shiftId, Long groupId, Long disciplineId, Long gradeId, Long bimester);
}
