package br.com.data.validation.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

import static java.lang.Long.parseLong;

@Slf4j
public final class CnpjUtility {

    private static final Random rnd = new Random();

    private CnpjUtility() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean validateCnpj(final String cnpj) {

        log.info("Starting CNPJ validation: {}", cnpj);

        if (cnpj == null || cnpj.length() != 14 || hasEqualSequentialNumbers(cnpj)) {
            log.info("Finishing CNPJ verification in utility class for invalid document: {}", cnpj);
            return false;
        }

        try {
            parseLong(cnpj);
        } catch (NumberFormatException exception) {
            return false;
        }

        var sum = 0;
        var cnpjCalculated = cnpj.substring(0, 12);
        var charCnpj = cnpj.toCharArray();
        int[] multipliers = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        for (int i = 0; i < 12; i++) {
            sum += (charCnpj[i] - '0') * multipliers[i];
        }

        var remainder = sum % 11;

        if (remainder < 2) {
            cnpjCalculated += "0";
        } else {
            cnpjCalculated += (11 - remainder);
        }

        sum = 0;
        charCnpj = cnpjCalculated.toCharArray();

        int[] multipliers2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        for (int i = 0; i < 13; i++) {
            sum += (charCnpj[i] - '0') * multipliers2[i];
        }

        remainder = sum % 11;
        if (remainder < 2) {
            cnpjCalculated += "0";
        } else {
            cnpjCalculated += (11 - remainder);
        }

        log.info("Finishing CNPJ verification in utility class for valid document: {}", cnpj);
        return cnpj.equals(cnpjCalculated);
    }

    private static boolean hasEqualSequentialNumbers(final String cnpj) {
        log.info("Starting equal numbers verification in CNPJ: {}", cnpj);
        final var equalSequentialNumbers = cnpj.chars().allMatch(c -> c == cnpj.charAt(0));
        log.info("Finishing equal numbers verification in CNPJ: {}", cnpj);
        return equalSequentialNumbers;
    }

    public static String generateValidCnpj() {

        log.info("Starting CNPJ generation in utility class");

        final var cnpj = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            cnpj.append(rnd.nextInt(10));
        }

        cnpj.append(calcularDigitoVerificadorCnpj(cnpj.toString()));
        cnpj.append(calcularDigitoVerificadorCnpj(cnpj.toString()));

        log.info("Finishing CNPJ generation in utility class for valid document {}", cnpj);
        return cnpj.toString();
    }

    private static char calcularDigitoVerificadorCnpj(final String cnpj) {

        log.info("Starting CNPJ generation in utility class");

        var sum = 0;
        int digit;
        int[] weight = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        for (int i = cnpj.length() - 1; i >= 0; i--) {
            digit = cnpj.charAt(i) - '0';
            sum += digit * weight[weight.length - cnpj.length() + i];
        }

        sum %= 11;
        sum = (sum < 2) ? 0 : 11 - sum;

        log.info("Finishing CNPJ generation in utility class for valid document {}", cnpj);
        return (char) (sum + '0');
    }

}
