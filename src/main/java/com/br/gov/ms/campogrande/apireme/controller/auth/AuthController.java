package com.br.gov.ms.campogrande.apireme.controller.auth;

import com.br.gov.ms.campogrande.apireme.service.AuthService;
import com.br.gov.ms.campogrande.apireme.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Gerenciamento de Autenticação", description = "Operações relacionadas a autenticação do usuário")
public class AuthController {

    private final AuthService authService;

    @GetMapping
    @Operation(summary = "Autentica no sistema", description = "Autentica no sistema e retorna uma lista de professores e professores substitutos")
    public ResponseEntity<Object> login(@RequestHeader("Authorization") String token) {
        return ResponseUtil.generateResponse(authService.authenticate(token), HttpStatus.OK, "Usuário encontrado com sucesso!");
    }
}
