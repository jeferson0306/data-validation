package br.com.data.validation.controller;

import br.com.data.validation.domain.response.ValidationResponse;
import br.com.data.validation.service.GenerateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
public class GenerateController {

    private final GenerateService generateService;

    @GetMapping("/generate-cpf")
    public ResponseEntity<ValidationResponse> generateCpf() {
        log.info("Starting the request for CPF generation");
        final var responseMessage = generateService.generateCpf();
        log.info("Finishing the request for CPF generation: {}", responseMessage.message());
        return ok(responseMessage);
    }

    @GetMapping("/generate-cnpj")
    public ResponseEntity<ValidationResponse> generateCnpj() {
        log.info("Starting the request for CNPJ generation");
        final var responseMessage = generateService.generateCnpj();
        log.info("Finishing the request for CNPJ generation: {}", responseMessage.message());
        return ok(responseMessage);
    }

    @GetMapping("/generate-cep")
    public ResponseEntity<ValidationResponse> generateCep() {
        log.info("Starting the request for CEP generation");
        final var responseMessage = generateService.generateCep();
        log.info("Finishing the request for CEP generation: {}", responseMessage.message());
        return ok(responseMessage);
    }

    @GetMapping("/generate-name")
    public ResponseEntity<ValidationResponse> generateName() {
        log.info("Starting the request for name generation");
        final var responseMessage = generateService.generateName();
        log.info("Finishing the request for name generation: {}", responseMessage.message());
        return ok(responseMessage);
    }

}