package com.br.gov.ms.campogrande.apireme.util;

import com.br.gov.ms.campogrande.apireme.exception.BadRequestException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

public class TokenUtil {

    @SuppressWarnings("unchecked")
    public static String extractCpfFromToken(String token) {
        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }

            String[] parts = token.split("\\.");
            if (parts.length < 2) throw new IllegalArgumentException("Token inválido");

            String payload = new String(Base64.getDecoder().decode(parts[1]), StandardCharsets.UTF_8);
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
