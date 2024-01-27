package br.com.data.validation.service;

import br.com.data.validation.domain.response.ValidationResponse;
import br.com.data.validation.util.CnpjUtility;
import br.com.data.validation.util.CpfUtility;
import br.com.data.validation.util.NameUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@Service
public class ValidationService {

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

    public ValidationResponse validateName(final String name) {
        log.info("Starting the name validation: {}", name);
        if (NameUtility.validateName(name)) {
            log.info("The provided name is valid: {}", name);
            return new ValidationResponse(OK, "The provided name is valid: " + name);
        } else {
            log.error("The provided name is invalid: {}", name);
            return new ValidationResponse(OK, "The provided name is invalid: " + name);
        }
    }
}