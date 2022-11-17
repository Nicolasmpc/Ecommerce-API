package br.com.nicolasmpc.ecommerceapi.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class DTO {

    private HttpStatus status;
    private boolean success;
}
