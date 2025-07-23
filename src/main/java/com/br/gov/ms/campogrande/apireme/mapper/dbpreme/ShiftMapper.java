package com.br.gov.ms.campogrande.apireme.mapper.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.ShiftDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.Shift;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShiftMapper {

    ShiftDTO toDTO(Shift model);

    Shift toModel(ShiftDTO dto);
}
