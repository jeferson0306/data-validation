package br.com.data.validation.service;

import br.com.data.validation.domain.response.ValidationResponse;
import br.com.data.validation.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@Service
public class ValidationService {

    public ValidationResponse validateCep(final String cep) {
        log.info("Starting the CEP validation: {}", cep);
        final boolean isValidCep = CepUtility.validateCep(cep);
        if (isValidCep) {
            log.info("The provided CEP is valid: {}", cep);
            return new ValidationResponse(OK, "The provided CEP is valid: " + cep);
        } else {
            log.error("The provided CEP is invalid: {}", cep);
            return new ValidationResponse(OK, "The provided CEP is invalid: " + cep);
        }
    }

    public ValidationResponse validateCnpj(final String cnpj) {
        log.info("Starting the CNPJ validation: {}", cnpj);
        if (CnpjUtility.validateCnpj(cnpj)) {
            log.info("The provided CNPJ is valid: {}", cnpj);
            return new ValidationResponse(OK, "The provided CNPJ is valid: " + cnpj);
        } else {
            log.error("The provided CNPJ is invalid: {}", cnpj);
            return new ValidationResponse(OK, "The provided CNPJ is invalid: " + cnpj);
        }
    }

    public ValidationResponse validateCnh(final String cnh) {
        log.info("Starting the CNH validation: {}", cnh);
        if (CnhUtility.validateCnh(cnh)) {
            log.info("The provided CNH is valid: {}", cnh);
            return new ValidationResponse(OK, "The provided CNH is valid: " + cnh);
        } else {
            log.error("The provided CNH is invalid: {}", cnh);
            return new ValidationResponse(OK, "The provided CNH is invalid: " + cnh);
        }
    }

    public ValidationResponse validateCpf(final String cpf) {
        log.info("Starting the CPF validation: {}", cpf);
        final var document = CpfUtility.validateCpf(cpf);
        if (document != null) {
            log.info("The provided CPF is valid: {}", cpf);
            return new ValidationResponse(OK, "The provided CPF is valid: " + cpf);
        } else {
            log.error("The provided CPF is invalid: {}", cpf);
            return new ValidationResponse(OK, "The provided CPF is invalid: " + cpf);
        }
    }

    public ValidationResponse validateEmail(final String email) {
        log.info("Starting the email validation: {}", email);
        final var isValidEmail = EmailUtility.validateEmail(email);
        if (isValidEmail) {
            log.info("The provided email is valid: {}", email);
            return new ValidationResponse(OK, "The provided email is valid: " + email);
        } else {
            log.error("The provided email is invalid: {}", email);
            return new ValidationResponse(OK, "The provided email is invalid: " + email);
        }
    }

    public ValidationResponse validateName(final String name) {
        log.info("Starting the name validation: {}", name);
        final var cleanedName = NameUtility.validateName(name);
        if (cleanedName != null) {
            log.info("The provided name is valid: {}", cleanedName);
            return new ValidationResponse(OK, "The provided name is valid: " + cleanedName);
        } else {
            log.error("The provided name is invalid: {}", name);
            return new ValidationResponse(OK, "The provided name is invalid: " + name);
        }
    }

    public ValidationResponse validatePhone(final String phone) {
        log.info("Starting the phone validation: {}", phone);
        if (PhoneUtility.validatePhone(phone)) {
            log.info("The provided phone is valid: {}", phone);
            return new ValidationResponse(OK, "The provided phone is valid: " + phone);
        } else {
            log.error("The provided phone is invalid: {}", phone);
            return new ValidationResponse(OK, "The provided phone is invalid: " + phone);
        }
    }

}