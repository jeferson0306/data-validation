package br.com.data.validation.domain.response;

import org.springframework.http.HttpStatus;

public record ValidationResponse(HttpStatus response, String message) {
}