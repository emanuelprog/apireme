package com.br.gov.ms.campogrande.apireme.controller.auth;

import com.br.gov.ms.campogrande.apireme.service.auth.AuthService;
import com.br.gov.ms.campogrande.apireme.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping
    public ResponseEntity<Object> login(@RequestHeader("Authorization") String token) {
        return ResponseUtil.generateResponse(authService.authenticate(token), HttpStatus.OK, "Usuário encontrado com sucesso!");
    }
}
