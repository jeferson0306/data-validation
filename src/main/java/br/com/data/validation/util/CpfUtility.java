package br.com.data.validation.util;

import br.com.data.validation.domain.exception.InvalidDocumentException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class CpfUtility {

    private CpfUtility() {
        throw new IllegalStateException("CpfUtility class");
    }

    public static String validateCpf(final String document) {

        log.info("Starting invalid data validation in utility class for document {}", document);

        if (document == null) return null;
        if (document.isEmpty()) return null;
        if (document.trim().isEmpty()) return null;
        if (document.equalsIgnoreCase("0")) return null;
        final var cpf = document.replaceAll("\\D", "");
        if (!isCPF(cpf)) return null;
        log.info("Finishing CPF verification in utility class for invalid document {}", cpf);

        return document;
    }

    public static boolean isCPF(final String cpf) {

        log.info("Starting CPF verification in utility class for document {}", cpf);

        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") || (cpf.length() != 11))
            return (false);

        final char dig10;
        final char dig11;
        int sum;
        int i;
        int remainder;
        int num;
        int peso;

        try {
            sum = 0;
            peso = 10;

            for (i = 0; i < 9; i++) {
                num = cpf.charAt(i) - 48;
                sum = sum + (num * peso);
                peso = peso - 1;
            }

            remainder = 11 - (sum % 11);
            if ((remainder == 10) || (remainder == 11)) dig10 = '0';
            else dig10 = (char) (remainder + 48);

            sum = 0;
            peso = 11;

            for (i = 0; i < 10; i++) {
                num = cpf.charAt(i) - 48;
                sum = sum + (num * peso);
                peso = peso - 1;
            }

            remainder = 11 - (sum % 11);
            if ((remainder == 10) || (remainder == 11)) dig11 = '0';
            else dig11 = (char) (remainder + 48);

            log.info("Finishing CPF verification in utility class for valid document {}", cpf);
            return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));

        } catch (InvalidDocumentException exception) {
            log.error("Error verifying the provided CPF in the utility class for the document {} with error: {}", cpf, exception.getMessage());
            return (false);
        }
    }
}
