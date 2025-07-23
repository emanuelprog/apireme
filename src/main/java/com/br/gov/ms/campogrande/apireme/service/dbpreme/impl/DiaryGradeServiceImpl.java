package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.DiaryGradeDTO;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.DiaryGradeMapper;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.DiaryGradeRepository;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.DiaryGradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryGradeServiceImpl implements DiaryGradeService {

    private final DiaryGradeRepository diaryGradeRepository;
    private final DiaryGradeMapper diaryGradeMapper;

    @Override
    public List<DiaryGradeDTO> findByFilter(String enrollment, Long teachingTypeId, String sector, Long year, Long shiftId, Long groupId, Long disciplineId, Long gradeId, Long bimester) {
        return diaryGradeRepository.findFiltered(enrollment, teachingTypeId, sector, year, shiftId, groupId, disciplineId, gradeId, bimester)
                .stream().map(diaryGradeMapper::toDTO).toList();
    }
}
