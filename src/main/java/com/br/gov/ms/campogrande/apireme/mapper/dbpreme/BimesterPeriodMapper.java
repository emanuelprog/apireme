package com.br.gov.ms.campogrande.apireme.mapper.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.BimesterPeriodDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.BimesterPeriod;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BimesterPeriodMapper {

    BimesterPeriodDTO toDTO(BimesterPeriod model);

    BimesterPeriod toModel(BimesterPeriodDTO dto);
}
