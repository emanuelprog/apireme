package com.br.gov.ms.campogrande.apireme.mapper.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.GroupDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.Group;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    GroupDTO toDTO(Group model);

    Group toModel(GroupDTO dto);
}
