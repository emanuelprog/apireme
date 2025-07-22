package com.br.gov.ms.campogrande.apireme.mapper.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.SchoolDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.SchoolCoordinatorDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.SchoolCoordinator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SchoolCoordinatorMapper {

    SchoolCoordinatorDTO toDTO(SchoolCoordinator model);

    @Mapping(source = "sector", target = "sector")
    @Mapping(source = "sectorName", target = "sectorName")
    @Mapping(source = "enrollment", target = "enrollment")
    SchoolDTO toSchoolDTO(SchoolCoordinator model);
}