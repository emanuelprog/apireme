package com.br.gov.ms.campogrande.apireme.mapper.dbergon;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.TeacherDTO;
import com.br.gov.ms.campogrande.apireme.model.dbergon.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface TeacherMapper {

    TeacherDTO toDTO(Teacher model);

    Teacher toModel(TeacherDTO dto);
}
