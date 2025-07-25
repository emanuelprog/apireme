package com.br.gov.ms.campogrande.apireme.controller.dbpreme;

import com.br.gov.ms.campogrande.apireme.service.dbpreme.HistoryService;
import com.br.gov.ms.campogrande.apireme.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/histories")
@RequiredArgsConstructor
@Tag(name = "Gerenciamento de Histórico do Aluno", description = "Operações relacionadas ao gerenciamento de histórico dos alunos das telas 'Frequência' e 'Média'")
public class HistoryController {

    private final HistoryService historyService;

    @GetMapping("/student/{id}")
    @Operation(summary = "Escolas do Professor", description = "Retorna as unidades escolares associadas ao professor informado")
    public ResponseEntity<Object> getSchoolsByTeacher(@PathVariable Long id) {
        return ResponseUtil.generateResponse(historyService.findHistoriesFrequencyByStudent(id), HttpStatus.OK);
    }
}
