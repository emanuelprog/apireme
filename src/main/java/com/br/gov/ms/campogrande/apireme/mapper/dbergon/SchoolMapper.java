package com.br.gov.ms.campogrande.apireme.mapper.dbergon;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.SchoolDTO;
import com.br.gov.ms.campogrande.apireme.model.dbergon.School;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { SchoolSectorMapper.class })
public interface SchoolMapper {

    @Mapping(target = "schoolNumber", source = "schoolSector")
    SchoolDTO toDTO(School model);

    School toModel(SchoolDTO dto);
}
