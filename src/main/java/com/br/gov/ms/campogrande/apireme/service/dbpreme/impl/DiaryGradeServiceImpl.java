package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.BimesterPeriodDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.DiaryCreationInfoDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.DiaryGradeDTO;
import com.br.gov.ms.campogrande.apireme.exception.NotFoundException;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.BimesterPeriodMapper;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.DiaryGradeMapper;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.BimesterPeriodRepository;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.DiaryGradeRepository;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.TeacherScheduleRepository;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.DiaryGradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryGradeServiceImpl implements DiaryGradeService {

    private final DiaryGradeRepository diaryGradeRepository;
    private final DiaryGradeMapper diaryGradeMapper;

    private final TeacherScheduleRepository teacherScheduleRepository;
    private final BimesterPeriodRepository bimesterPeriodRepository;
    private final BimesterPeriodMapper bimesterPeriodMapper;

    @Override
    public List<DiaryGradeDTO> findByFilter(String enrollment, Long teachingTypeId, String sector, Long year, Long shiftId, Long groupId, Long disciplineId, Long gradeId, Long bimester) {
        return diaryGradeRepository.findFiltered(enrollment, teachingTypeId, sector, year, shiftId, groupId, disciplineId, gradeId, bimester)
                .stream().map(diaryGradeMapper::toDTO).toList();
    }

    @Override
    public DiaryCreationInfoDTO findInfoForCreation(String enrollment, Long teachingTypeId, Long schoolNumber, Long year, Long shiftId, Long bimester) {
        Long teacherScheduleId = teacherScheduleRepository.findIdByParams(teachingTypeId, schoolNumber, enrollment, year, shiftId)
                .orElseThrow(() -> new NotFoundException("Horario do Professor não encontrado com os dados informados"));

        BimesterPeriodDTO bimesterPeriodDTO = bimesterPeriodRepository.findBimesterPeriodId(bimester, year).map(bimesterPeriodMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("Período do bimestre não encontrado para o ano informado"));

        return new DiaryCreationInfoDTO(teacherScheduleId, bimesterPeriodDTO);
    }
}
