package com.br.gov.ms.campogrande.apireme.mapper.dbergon;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.AddressDTO;
import com.br.gov.ms.campogrande.apireme.model.dbergon.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO toDTO(Address model);

    Address toModel(AddressDTO dto);
}