package br.com.data.validation.controller;

import br.com.data.validation.domain.response.ValidationResponse;
import br.com.data.validation.service.ValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ValidationController {

    private final ValidationService validationService;

    @GetMapping("/validate-cep/{cep}")
    public ResponseEntity<ValidationResponse> validateCep(@PathVariable final String cep) {
        log.info("Starting the request for CEP validation: {}", cep);
        final var responseMessage = validationService.validateCep(cep);
        log.info("Finishing the request for CEP validation: {}", responseMessage.message());
        return ok(new ValidationResponse(OK, responseMessage.message()));
    }

    @GetMapping("/validate-cnpj/{cnpj}")
    public ResponseEntity<ValidationResponse> validateCnpj(@PathVariable final String cnpj) {
        log.info("Starting the request for CNPJ validation: {}", cnpj);
        final var responseMessage = validationService.validateCnpj(cnpj);
        log.info("Finishing the request for CNPJ validation: {}", responseMessage.message());
        return ok(new ValidationResponse(OK, responseMessage.message()));
    }

    @GetMapping("/validate-cnh/{cnh}")
    public ResponseEntity<ValidationResponse> validateCnh(@PathVariable final String cnh) {
        log.info("Starting the request for CNH validation: {}", cnh);
        final var responseMessage = validationService.validateCnh(cnh);
        log.info("Finishing the request for CNH validation: {}", responseMessage.message());
        return ok(new ValidationResponse(OK, responseMessage.message()));
    }

    @GetMapping("/validate-cpf/{cpf}")
    public ResponseEntity<ValidationResponse> validateCpf(@PathVariable final String cpf) {
        log.info("Starting the request for CPF validation: {}", cpf);
        final var responseMessage = validationService.validateCpf(cpf);
        log.info("Finishing the request for CPF validation: {}", responseMessage.message());
        return ok(new ValidationResponse(OK, responseMessage.message()));
    }

    @GetMapping("/validate-email/{email}")
    public ResponseEntity<ValidationResponse> validateEmail(@PathVariable final String email) {
        log.info("Starting the request for email validation: {}", email);
        final var responseMessage = validationService.validateEmail(email);
        log.info("Finishing the request for email validation: {}", responseMessage.message());
        return ok(new ValidationResponse(OK, responseMessage.message()));
    }

    @GetMapping("/validate-name/{name}")
    public ResponseEntity<ValidationResponse> validateName(@PathVariable final String name) {
        log.info("Starting the request for name validation: {}", name);
        final var responseMessage = validationService.validateName(name);
        log.info("Finishing the request for name validation: {}", responseMessage.message());
        return ok(new ValidationResponse(OK, responseMessage.message()));
    }

    @GetMapping("/validate-phone/{phone}")
    public ResponseEntity<ValidationResponse> validatePhone(@PathVariable final String phone) {
        log.info("Starting the request for phone validation: {}", phone);
        final var responseMessage = validationService.validatePhone(phone);
        log.info("Finishing the request for phone validation: {}", responseMessage.message());
        return ok(new ValidationResponse(OK, responseMessage.message()));
    }

}