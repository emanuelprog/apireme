package com.br.gov.ms.campogrande.apireme.mapper.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.DiaryGradeDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.DiaryGrade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        GroupMapper.class, ShiftMapper.class,
        GradeMapper.class, TeachingTypeMapper.class,
        BimesterPeriodMapper.class, DisciplineMapper.class })
public interface DiaryGradeMapper {

    DiaryGradeDTO toDTO(DiaryGrade model);

    DiaryGrade toModel(DiaryGradeDTO dto);
}
