package br.com.nicolasmpc.ecommerceapi.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nicolasmpc.ecommerceapi.dto.response.AuthResponseDTO;
import br.com.nicolasmpc.ecommerceapi.service.AuthService;

@RestController
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    @PostMapping("/api/auth")
    public ResponseEntity<AuthResponseDTO> authenticate(Authentication auth) {
        Jwt jwt = authService.generateToken(auth);

        LocalDateTime expiresAt = LocalDateTime.ofInstant(jwt.getExpiresAt(), ZoneId.of("America/Sao_Paulo"));

        return ResponseEntity.ok().
                body(new AuthResponseDTO(
                    HttpStatus.OK,
                    true,
                    jwt.getTokenValue(),
                    expiresAt
                ));        
    }
}
