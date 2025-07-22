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
    public ResponseEntity<Object> getSchoolsByTeacher(@RequestParam String enrollment, @RequestParam Boolean isCoordinator) {
        return ResponseUtil.generateResponse(filterService.findSchoolsByEnrollment(enrollment, isCoordinator), HttpStatus.OK);
    }

    @GetMapping("/year")
    @Operation(summary = "Anos de Referência", description = "Retorna todos os anos de referência a partir de um horario do professor")
    public ResponseEntity<Object> getAllYear(@RequestParam Long teachingTypeId, @RequestParam String sector, @RequestParam String enrollment) {
        return ResponseUtil.generateResponse(filterService.findAllYear(teachingTypeId, sector, enrollment), HttpStatus.OK);
    }
}
