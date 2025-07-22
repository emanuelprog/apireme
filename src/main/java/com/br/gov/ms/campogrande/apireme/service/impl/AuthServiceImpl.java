package com.br.gov.ms.campogrande.apireme.service.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.TeacherDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.SubstituteTeacherDTO;
import com.br.gov.ms.campogrande.apireme.exception.BadRequestException;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.CoordinatorMapper;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.SubstituteTeacherMapper;
import com.br.gov.ms.campogrande.apireme.service.AuthService;
import com.br.gov.ms.campogrande.apireme.service.dbergon.TeacherService;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.CoordinatorService;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.SubstituteTeacherService;
import com.br.gov.ms.campogrande.apireme.util.TokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final SubstituteTeacherService substituteTeacherService;
    private final CoordinatorService coordinatorService;
    private final TeacherService teacherService;
    private final SubstituteTeacherMapper substituteTeacherMapper;
    private final CoordinatorMapper coordinatorMapper;

    @Override
    public List<TeacherDTO> authenticate(String token) {
        String cpf = TokenUtil.extractCpfFromToken(token);

        List<TeacherDTO> teachers = new ArrayList<>();

        if (tryAddCoordinator(cpf, teachers)) return teachers;
        if (tryAddTeacher(cpf, teachers)) return teachers;
        if (tryAddSubstitute(cpf, teachers)) return teachers;

        throw new BadRequestException("Usuário ou senha inválidos");
    }

    private boolean tryAddCoordinator(String cpf, List<TeacherDTO> teachers) {
        return coordinatorService.findByCPF(cpf)
                .map(coordinatorMapper::toTeacherDTO)
                .map(dto -> teachers.add(dto))
                .orElse(false);
    }

    private boolean tryAddTeacher(String cpf, List<TeacherDTO> teachers) {
        return teacherService.findByCPF(cpf)
                .map(teachers::add)
                .orElse(false);
    }

    private boolean tryAddSubstitute(String cpf, List<TeacherDTO> teachers) {
        List<SubstituteTeacherDTO> substituted = substituteTeacherService.findBySubstituteCPF(cpf);

        if (substituted.isEmpty()) return false;

        if (substituted.size() == 1) {
            teachers.add(substituteTeacherMapper.toTeacherDTOWithSubstitution(substituted.getFirst()));
        } else {
            substituted.stream()
                    .map(substituteTeacherMapper::toTeacherDTOWithSubstitution)
                    .forEach(teachers::add);
        }

        return true;
    }
}
