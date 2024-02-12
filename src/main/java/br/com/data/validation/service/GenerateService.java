package br.com.data.validation.service;

import br.com.data.validation.domain.response.ValidationResponse;
import br.com.data.validation.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@Service
public class GenerateService {

    public ValidationResponse generateCpf() {
        log.info("Starting the request for CPF generation");
        final var cpf = CpfUtility.generateValidCpf();
        log.info("Finishing the request for CPF generation: {}", cpf);
        return new ValidationResponse(OK, "Generated valid CPF: " + cpf);
    }

    public ValidationResponse generateCnpj() {
        log.info("Starting the request for CNPJ generation");
        final var cnpj = CnpjUtility.generateValidCnpj();
        log.info("Finishing the request for CNPJ generation: {}", cnpj);
        return new ValidationResponse(OK, "Generated valid CNPJ: " + cnpj);
    }

    public ValidationResponse generateCep() {
        log.info("Starting the request for CEP generation");
        final var cep = CepUtility.generateValidCep();
        log.info("Finishing the request for CEP generation: {}", cep);
        return new ValidationResponse(OK, "Generated valid CEP: " + cep);
    }

    public ValidationResponse generateName() {
        log.info("Starting the request for name generation");
        final var name = NameUtility.generateValidName();
        log.info("Finishing the request for name generation: {}", name);
        return new ValidationResponse(OK, "Generated valid name: " + name);
    }

    public ValidationResponse generatePhone() {
        log.info("Starting the request for phone number generation");
        final var phone = PhoneUtility.generateValidPhone();
        log.info("Finishing the request for phone number generation: {}", phone);
        return new ValidationResponse(OK, "Generated valid phone number: " + phone);
    }

}