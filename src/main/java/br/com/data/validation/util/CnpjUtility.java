package br.com.data.validation.util;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Long.parseLong;

@Slf4j
public final class CnpjUtility {

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
}
