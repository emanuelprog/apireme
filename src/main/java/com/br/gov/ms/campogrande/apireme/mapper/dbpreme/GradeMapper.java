package com.br.gov.ms.campogrande.apireme.mapper.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.GradeDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.Grade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GradeMapper {

    GradeDTO toDTO(Grade model);

    Grade toModel(GradeDTO dto);
}
