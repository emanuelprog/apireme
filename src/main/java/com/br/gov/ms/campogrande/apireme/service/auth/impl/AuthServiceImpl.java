package com.br.gov.ms.campogrande.apireme.service.auth.impl;

import com.br.gov.ms.campogrande.apireme.dto.dbergon.TeacherDTO;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.SubstituteTeacherDTO;
import com.br.gov.ms.campogrande.apireme.exception.BadRequestException;
import com.br.gov.ms.campogrande.apireme.exception.NotFoundException;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.CoordinatorMapper;
import com.br.gov.ms.campogrande.apireme.mapper.dbpreme.SubstituteTeacherMapper;
import com.br.gov.ms.campogrande.apireme.service.auth.AuthService;
import com.br.gov.ms.campogrande.apireme.service.dbergon.TeacherService;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.CoordinatorService;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.SubstituteTeacherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

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
        String cpf = extractCpfFromToken(token);

        List<TeacherDTO> teachers = new ArrayList<>();

        addCoordinatorIfExists(cpf, teachers);

        if (teachers.isEmpty()) {
            addTeacherIfExists(cpf, teachers);
        }

        if (teachers.isEmpty()) {
            addSubstituteTeacherIfExists(cpf, teachers);
        }

        if (teachers.stream().anyMatch(Objects::nonNull)) {
            return teachers;
        }

        throw new BadRequestException("Usuário ou senha inválidos");
    }

    private void addCoordinatorIfExists(String cpf, List<TeacherDTO> teachers) {
        coordinatorService.findByCPF(cpf)
                .ifPresent(coordinatorDTO -> teachers.add(coordinatorMapper.toTeacherDTO(coordinatorDTO)));
    }

    private void addTeacherIfExists(String cpf, List<TeacherDTO> teachers) {
        teacherService.findByCPF(cpf)
                .ifPresent(teacherDTO -> teachers.add(teacherDTO));
    }

    private void addSubstituteTeacherIfExists(String cpf, List<TeacherDTO> teachers) {
        try {
            SubstituteTeacherDTO dto = substituteTeacherService.findBySubstituteCPF(cpf);
            TeacherDTO teacher = substituteTeacherMapper.toTeacherDTOWithSubstitution(dto);
            if (teachers.stream().noneMatch(t -> t.getCpf().equals(teacher.getCpf()))) {
                teachers.add(teacher);
            }
        } catch (NotFoundException ignored) {
        }

        List<SubstituteTeacherDTO> holderSubs = substituteTeacherService.findByHolderCPF(cpf);
        holderSubs.forEach(dto -> {
            TeacherDTO teacher = substituteTeacherMapper.toTeacherDTOWithSubstitution(dto);
            if (teachers.stream().noneMatch(t -> t.getCpf().equals(teacher.getCpf()))) {
                teachers.add(teacher);
            }
        });
    }

    private String extractCpfFromToken(String token) {
        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }

            String[] parts = token.split("\\.");
            if (parts.length < 2) throw new IllegalArgumentException("Token inválido");

            String payload = new String(Base64.getDecoder().decode(parts[1]), "UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> claims = mapper.readValue(payload, Map.class);

            Object cpf = claims.get("cpf");
            if (cpf == null) throw new IllegalArgumentException("CPF não encontrado no token");

            return cpf.toString();
        } catch (Exception e) {
            throw new BadRequestException("Token inválido ou malformado");
        }
    }
}
