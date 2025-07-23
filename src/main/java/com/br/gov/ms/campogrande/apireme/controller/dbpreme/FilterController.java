package com.br.gov.ms.campogrande.apireme.controller.dbpreme;

import com.br.gov.ms.campogrande.apireme.service.FilterService;
import com.br.gov.ms.campogrande.apireme.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filter")
@RequiredArgsConstructor
@Tag(name = "Gerenciamento de Filtros", description = "Operações relacionadas ao gerenciamento de filtros das telas 'Frequência', 'Plano de Aula' e 'Média'")
public class FilterController {

    private final FilterService filterService;

    @GetMapping("/teachingType")
    @Operation(summary = "Tipos de Ensino", description = "Retorna uma lista com todos os tipos de ensino cadastrados")
    public ResponseEntity<Object> getAllTeachingType() {
        return ResponseUtil.generateResponse(filterService.findAllTeachingType(), HttpStatus.OK);
    }

    @GetMapping("/school")
    @Operation(summary = "Escolas do Professor", description = "Retorna as unidades escolares associadas ao professor informado")
    public ResponseEntity<Object> getSchoolsByTeacher(
            @RequestParam String enrollment,
            @RequestParam Boolean isCoordinator
    ) {
        return ResponseUtil.generateResponse(filterService.findSchoolsByEnrollment(enrollment, isCoordinator), HttpStatus.OK);
    }

    @GetMapping("/year")
    @Operation(summary = "Anos de Referência", description = "Retorna todos os anos de referência a partir de um horario do professor")
    public ResponseEntity<Object> getAllYear(
            @RequestParam Long teachingTypeId,
            @RequestParam Long schoolNumber,
            @RequestParam String enrollment
    ) {
        return ResponseUtil.generateResponse(filterService.findAllYear(teachingTypeId, schoolNumber, enrollment), HttpStatus.OK);
    }

    @GetMapping("/shift")
    @Operation(summary = "Turnos", description = "Retorna todos os turnos disponíveis para um professor")
    public ResponseEntity<Object> getAllShifts(
            @RequestParam Long teachingTypeId,
            @RequestParam Long schoolNumber,
            @RequestParam String enrollment,
            @RequestParam Long year
    ) {
        return ResponseUtil.generateResponse(filterService.findAllShifts(teachingTypeId, schoolNumber, enrollment, year), HttpStatus.OK);
    }

    @GetMapping("/group")
    @Operation(summary = "Grupos", description = "Retorna todos os grupos disponíveis para um professor")
    public ResponseEntity<Object> getAllGroups(
            @RequestParam Long teachingTypeId,
            @RequestParam Long schoolNumber,
            @RequestParam String enrollment,
            @RequestParam Long year,
            @RequestParam Long shiftId
    ) {
        return ResponseUtil.generateResponse(filterService.findAllGroups(teachingTypeId, schoolNumber, enrollment, year, shiftId), HttpStatus.OK);
    }

    @GetMapping("/discipline")
    @Operation(summary = "Disciplinas", description = "Retorna todas as disciplinas disponíveis para um professor")
    public ResponseEntity<Object> getAllDisciplines(
            @RequestParam Long teachingTypeId,
            @RequestParam Long schoolNumber,
            @RequestParam String enrollment,
            @RequestParam Long year,
            @RequestParam Long shiftId,
            @RequestParam Long groupId
    ) {
        return ResponseUtil.generateResponse(filterService.findAllDisciplines(teachingTypeId, schoolNumber, enrollment, year, shiftId, groupId), HttpStatus.OK);
    }

    @GetMapping("/grade")
    @Operation(summary = "Turmas", description = "Retorna todas as turmas disponíveis para um professor")
    public ResponseEntity<Object> getAllGrades(
            @RequestParam Long teachingTypeId,
            @RequestParam Long schoolNumber,
            @RequestParam String enrollment,
            @RequestParam Long year,
            @RequestParam Long shiftId,
            @RequestParam Long groupId,
            @RequestParam Long disciplineId
    ) {
        return ResponseUtil.generateResponse(filterService.findAllGrades(teachingTypeId, schoolNumber, enrollment, year, shiftId, groupId, disciplineId), HttpStatus.OK);
    }
}
