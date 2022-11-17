package br.com.nicolasmpc.ecommerceapi.dto.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import br.com.nicolasmpc.ecommerceapi.dto.DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDTO extends DTO{
     
    private String token;
    private LocalDateTime expiresAt;

    public AuthResponseDTO(HttpStatus status, boolean success,String token, LocalDateTime expiresAt) {
        super(status, success);
        this.token = token;
        this.expiresAt = expiresAt;
    }

    
}
