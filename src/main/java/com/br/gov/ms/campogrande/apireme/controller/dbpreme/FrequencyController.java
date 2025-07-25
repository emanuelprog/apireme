package com.br.gov.ms.campogrande.apireme.controller.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.FrequencyRequestDTO;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.FrequencyService;
import com.br.gov.ms.campogrande.apireme.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/frequencies")
@RequiredArgsConstructor
@Tag(name = "Gerenciamento de Frequências", description = "Operações relacionadas ao gerenciamento de frequência dos alunos da tela 'Frequência'")
public class FrequencyController {

    private final FrequencyService frequencyService;

    @GetMapping
    @Operation(summary = "Frequência e Colunas", description = "Retorna uma lista com todas as frequências por aluno cadastradas e as colunas por período do bimestre")
    public ResponseEntity<Object> getFrequencies(
            @RequestParam Long teacherScheduleId,
            @RequestParam Long disciplineId,
            @RequestParam String sector,
            @RequestParam String group,
            @RequestParam String grade,
            @RequestParam String shift,
            @RequestParam Long year,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
    ) {
        return ResponseUtil.generateResponse(frequencyService.getFrequencyResponse(teacherScheduleId, disciplineId, sector, group, grade, shift, year, from, to), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Diário e Frequência", description = "Salva o diário de classe e as frequências dos alunos")
    public ResponseEntity<Object> saveFrequencies(@RequestBody FrequencyRequestDTO frequencyRequestDTO) {
        return ResponseUtil.generateResponse(frequencyService.saveFrequencies(frequencyRequestDTO), HttpStatus.CREATED, "Frequências salvas com sucesso.");
    }
}
