package br.com.data.validation.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CnhUtility {

    private CnhUtility() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean validateCnh(final String cnh) {
        log.info("Starting CNH validation for: {}", cnh);

        if (cnh == null || cnh.length() != 11 || !cnh.matches("\\d+")) {
            return false;
        }

        var sum1 = 0;
        var sum2 = 0;
        var isGreater = false;

        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(cnh.charAt(i));
            sum1 += digit * (9 - i);
            sum2 += digit * (i + 1);
        }

        var dv1 = sum1 % 11;

        if (dv1 > 9) {
            dv1 = 0;
            isGreater = true;
        }

        sum2 += dv1 * 9;
        var dv2 = sum2 % 11;

        if (isGreater) {
            dv2 = dv2 - 2 < 0 ? dv2 + 9 : dv2 - 2;
        }

        if (dv2 > 9) {
            dv2 = 0;
        }

        final var isValid = cnh.substring(9).equals("" + dv1 + dv2);
        log.info("Finishing CNH validation for {} document: {}", isValid ? "valid" : "invalid", cnh);
        return isValid;
    }
}
