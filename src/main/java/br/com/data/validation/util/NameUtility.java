package br.com.data.validation.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class NameUtility {

    private static final Random rnd = new Random();

    private NameUtility() {
        throw new IllegalStateException("NameUtility class");
    }

    public static String validateName(final String name) {

        log.info("Starting name validation for: {}", name);

        if (name == null) {
            log.info("Name validation failed for: {}", name);
            return null;
        }

        final var cleanedName = name.replaceAll("\\d", "").trim().replaceAll("\\s+", " ");
        final var isValid = cleanedName.length() >= 3 && cleanedName.matches("[A-Za-zÀ-ÿ ]+");

        if (isValid) {
            log.info("Name validation passed for: {}", cleanedName);
            return cleanedName;
        } else {
            log.info("Name validation failed for: {}", name);
            return null;
        }
    }

    public static String generateValidName() {
        log.info("Starting the request for name generation");
        final String[] firstNames = {"Ana", "Bruno", "Carla", "David", "Elena", "Fernando"};
        final String[] lastNames = {"Silva", "Costa", "Machado", "Borges", "Ribeiro", "Alves"};
        final var firstName = firstNames[rnd.nextInt(firstNames.length)];
        final var lastName = lastNames[rnd.nextInt(lastNames.length)];
        log.info("Finishing the request for name generation: {}", firstName + " " + lastName);
        return firstName + " " + lastName;
    }
}
