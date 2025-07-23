package com.br.gov.ms.campogrande.apireme.mapper.dbergon;

import com.br.gov.ms.campogrande.apireme.model.dbergon.SchoolSector;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolSectorMapper {

    default Long map(SchoolSector schoolSector) {
        return schoolSector != null ? schoolSector.getSchoolNumber() : null;
    }
}