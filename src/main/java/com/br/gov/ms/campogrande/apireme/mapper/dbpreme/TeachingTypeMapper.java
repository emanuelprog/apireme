package com.br.gov.ms.campogrande.apireme.mapper.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.TeachingTypeDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.TeachingType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeachingTypeMapper {

    TeachingTypeDTO toDTO(TeachingType model);

    TeachingType toModel(TeachingTypeDTO dto);
}
