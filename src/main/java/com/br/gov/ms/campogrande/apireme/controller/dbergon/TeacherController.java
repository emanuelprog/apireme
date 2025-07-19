package com.br.gov.ms.campogrande.apireme.controller.dbergon;

import com.br.gov.ms.campogrande.apireme.service.dbergon.TeacherService;
import com.br.gov.ms.campogrande.apireme.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<Object> getAllTeachers() {
        return ResponseUtil.generateResponse(teacherService.findAll(), HttpStatus.OK, "Lista de professores encontrada.");
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> getByCpf(@PathVariable String cpf) {
        return ResponseUtil.generateResponse(teacherService.findByCPF(cpf), HttpStatus.OK, "Professor com CPF " + cpf + " encontrado.");
    }
}
