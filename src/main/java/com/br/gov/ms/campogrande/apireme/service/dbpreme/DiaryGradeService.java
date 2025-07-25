package com.br.gov.ms.campogrande.apireme.service.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.diary.DiaryCreationInfoDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.diary.DiaryGradeDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.DiaryGrade;

import java.util.List;

public interface DiaryGradeService {
    List<DiaryGradeDTO> findByFilter(String enrollment, Long teachingTypeId, String sector, Long year, Long shiftId, Long groupId, Long disciplineId, Long gradeId, Long bimester);

    DiaryCreationInfoDTO findInfoForCreation(String enrollment, Long teachingTypeId, Long schoolNumber, Long year, Long shiftId, Long bimester);

    DiaryGradeDTO save(DiaryGrade diaryGrade);
}
