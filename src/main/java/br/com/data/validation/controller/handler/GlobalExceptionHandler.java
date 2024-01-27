package br.com.data.validation.controller.handler;

import br.com.data.validation.domain.exception.InvalidDocumentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(OK)
    @ExceptionHandler(InvalidDocumentException.class)
    public ResponseEntity<String> handleInvalidCpfException(final InvalidDocumentException ex) {
        final var cpf = getCpfFromExceptionMessage(ex.getMessage());
        log.error("O cpf informado é inválido: {}", cpf);
        return status(OK).body(ex.getMessage());
    }

    private String getCpfFromExceptionMessage(final String message) {
        final var parts = message.split(": ");
        if (parts.length > 1) {
            return parts[1];
        } else {
            return "";
        }
    }
}
