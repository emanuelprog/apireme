package com.br.gov.ms.campogrande.apireme.mapper.dbergon;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.SchoolDTO;
import com.br.gov.ms.campogrande.apireme.model.dbergon.School;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolMapper {
    SchoolDTO toDTO(School model);

    School toModel(SchoolDTO dto);
}
