package br.com.data.validation.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

import static java.lang.String.format;

@Slf4j
public final class CepUtility {

    private static final Random rnd = new Random();

    private CepUtility() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean validateCep(final String cep) {
        return cep != null && cep.matches("\\d{5}-\\d{3}");
    }

    public static String generateValidCep() {
        final var firstPart = rnd.nextInt(100000);
        final var secondPart = rnd.nextInt(1000);
        return format("%05d-%03d", firstPart, secondPart);
    }

}
