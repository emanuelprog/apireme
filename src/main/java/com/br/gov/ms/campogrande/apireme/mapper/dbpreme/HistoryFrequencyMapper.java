package com.br.gov.ms.campogrande.apireme.mapper.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.HistoryFrequencyDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.HistoryFrequency;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoryFrequencyMapper {

    HistoryFrequencyDTO toDTO(HistoryFrequency model);

    HistoryFrequency toModel(HistoryFrequencyDTO dto);
}
