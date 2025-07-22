package com.br.gov.ms.campogrande.apireme.mapper.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.TeacherDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.CoordinatorDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.SubstituteTeacherDTO;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.SubstituteTeacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SubstituteTeacherMapper {

    SubstituteTeacherDTO toDTO(SubstituteTeacher model);

    SubstituteTeacher toModel(SubstituteTeacherDTO dto);

    TeacherDTO toTeacherDTO(CoordinatorDTO dto);

    @Named("toTeacherDTOFromSubstitute")
    @Mapping(target = "cpf", source = "substituteCPF")
    @Mapping(target = "name", source = "substituteName")
    @Mapping(target = "enrollment", expression = "java(parseLong(dto.getSubstituteEnrollment()))")
    @Mapping(target = "isCoordinator", constant = "false")
    @Mapping(target = "employmentLink", ignore = true)
    @Mapping(target = "departmentCode", ignore = true)
    @Mapping(target = "departmentName", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "specialty", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "leaveStatus", ignore = true)
    TeacherDTO toTeacherDTOFromSubstitute(SubstituteTeacherDTO dto);

    @Named("toTeacherDTOFromHolder")
    @Mapping(target = "cpf", source = "holderCPF")
    @Mapping(target = "name", source = "holderName")
    @Mapping(target = "enrollment", expression = "java(parseLong(dto.getHolderEnrollment()))")
    @Mapping(target = "isCoordinator", constant = "false")
    @Mapping(target = "employmentLink", ignore = true)
    @Mapping(target = "departmentCode", ignore = true)
    @Mapping(target = "departmentName", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "specialty", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "leaveStatus", ignore = true)
    TeacherDTO toTeacherDTOFromHolder(SubstituteTeacherDTO dto);

    @Mapping(target = "enrollment", expression = "java(parseLong(dto.getHolderEnrollment()))")
    @Mapping(source = "holderCPF", target = "holderCpf")
    @Mapping(source = "holderName", target = "holderName")
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