package com.br.gov.ms.campogrande.apireme.mapper.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.TeacherDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.CoordinatorDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.Coordinator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CoordinatorMapper {

    CoordinatorDTO toDTO(Coordinator model);

    Coordinator toModel(CoordinatorDTO dto);

    @Mapping(target = "employmentLink", ignore = true)
    @Mapping(target = "departmentCode", ignore = true)
    @Mapping(target = "departmentName", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "specialty", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "leaveStatus", ignore = true)
    @Mapping(target = "isCoordinator", constant = "true")
    TeacherDTO toTeacherDTO(CoordinatorDTO dto);
}
