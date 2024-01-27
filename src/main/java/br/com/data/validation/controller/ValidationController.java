package br.com.data.validation.controller;

import br.com.data.validation.domain.response.ValidationResponse;
import br.com.data.validation.service.ValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
public class ValidationController {

    private final ValidationService validationService;

    @GetMapping("/validate-cpf/{cpf}")
    public ResponseEntity<ValidationResponse> validateCpf(@PathVariable final String cpf) {
        log.info("Starting the request for CPF validation {}", cpf);
        final var responseMessage = validationService.validateCpf(cpf);
        log.info("Finishing the request for CPF validation {}", responseMessage.message());
        return ok(new ValidationResponse(OK, responseMessage.message()));
    }

    @GetMapping("/validate-cnpj/{cnpj}")
    public ResponseEntity<ValidationResponse> validateCnpj(@PathVariable final String cnpj) {
        log.info("Starting the request for CNPJ validation {}", cnpj);
        final var responseMessage = validationService.validateCnpj(cnpj);
        log.info("Finishing the request for CNPJ validation {}", responseMessage.message());
        return ok(new ValidationResponse(OK, responseMessage.message()));
    }
}