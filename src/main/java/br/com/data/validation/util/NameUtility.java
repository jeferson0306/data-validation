package br.com.data.validation.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NameUtility {

    private NameUtility() {
        throw new IllegalStateException("NameUtility class");
    }

    public static boolean validateName(final String name) {
        log.info("Starting name validation for: {}", name);
        final var isValid = name != null && name.trim().length() >= 3 && name.matches("[A-Za-zÀ-ÿ ]+");
        log.info("Finishing name validation for: {}", isValid ? "valid" : "invalid");
        return isValid;
    }
}
