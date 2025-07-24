package com.br.gov.ms.campogrande.apireme.mapper.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.TeacherDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.SubstituteTeacherDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.SubstituteTeacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubstituteTeacherMapper {

    SubstituteTeacherDTO toDTO(SubstituteTeacher model);

    SubstituteTeacher toModel(SubstituteTeacherDTO dto);

    @Mapping(target = "enrollment", expression = "java(parseLong(dto.getHolderEnrollment()))")
    @Mapping(source = "holderCPF", target = "holderCpf")
    @Mapping(source = "holderName", target = "holderName")
    @Mapping(source = "holderEmploymentLink", target = "employmentLink")
    @Mapping(source = "id", target = "substituteTeacherId")
    @Mapping(source = "substituteCPF", target = "cpf")
    @Mapping(source = "substituteName", target = "name")
    @Mapping(target = "isCoordinator", constant = "false")
    TeacherDTO toTeacherDTOWithSubstitution(SubstituteTeacherDTO dto);

    default Long parseLong(String value) {
        try {
            return value != null ? Long.parseLong(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}