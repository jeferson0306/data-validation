package br.com.data.validation.util;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

@Slf4j
public final class EmailUtility {

    private EmailUtility() {
        throw new IllegalStateException("EmailUtility class");
    }

    public static boolean validateEmail(final String email) {
        log.info("Starting email validation for: {}", email);

        if (email == null || email.isEmpty()) {
            log.error("Email cannot be null or empty");
            return false;
        }

        final var emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{2,})$";
        final var pattern = Pattern.compile(emailRegex);
        final var matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            log.error("Invalid email format for: {}", email);
            return false;
        }

        log.info("Email validation successful for: {}", email);
        return true;
    }
}
