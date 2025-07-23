package com.br.gov.ms.campogrande.apireme.mapper.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.DisciplineDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.Discipline;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DisciplineMapper {

    DisciplineDTO toDTO(Discipline model);

    Discipline toModel(DisciplineDTO dto);
}
