package com.br.gov.ms.campogrande.apireme.controller.dbpreme;

import com.br.gov.ms.campogrande.apireme.service.dbpreme.DiaryGradeService;
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
@RequestMapping("/diary")
@RequiredArgsConstructor
@Tag(name = "Gerenciamento de Diários de Classe", description = "Operações relacionadas ao gerenciamento de diários de classe das telas 'Frequência' e 'Média'")
public class DiaryGradeController {

    private final DiaryGradeService diaryGradeService;

    @GetMapping
    @Operation(summary = "Diário de Classe", description = "Retorna todas os diários de classe disponíveis para um professor")
    public ResponseEntity<Object> getAllGrades(
            @RequestParam String enrollment,
            @RequestParam Long teachingTypeId,
            @RequestParam String sector,
            @RequestParam Long year,
            @RequestParam Long shiftId,
            @RequestParam Long groupId,
            @RequestParam Long disciplineId,
            @RequestParam Long gradeId,
            @RequestParam Long bimester
    ) {
        return ResponseUtil.generateResponse(diaryGradeService.findByFilter(enrollment, teachingTypeId, sector, year, shiftId, groupId, disciplineId, gradeId, bimester), HttpStatus.OK);
    }
}
