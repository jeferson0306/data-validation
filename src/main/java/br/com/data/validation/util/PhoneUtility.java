package br.com.data.validation.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.regex.Pattern;

@Slf4j
public final class PhoneUtility {

    private static final Random rnd = new Random();

    private PhoneUtility() {
        throw new IllegalStateException("PhoneUtility class");
    }

    public static boolean validatePhone(String phone) {

        log.info("Starting phone validation for: {}", phone);

        phone = phone.replaceAll("\\D", "");

        log.info("Validating phone number length: {}", phone.length());
        if (phone.length() < 10 || phone.length() > 11) {
            log.error("Invalid phone number length for: {}", phone);
            return false;
        }

        log.info("Phone: {} contains 10 numbers, adding number 9 to the phone number: {}", phone, phone);
        if (phone.length() == 10) {
            phone = "9" + phone;
        }

        log.info("Separating DDD and phone number: {}", phone);
        final var ddd = phone.substring(0, 2);
        final var phoneNumber = phone.substring(2);

        if (!isValidDDD(ddd)) {
            log.error("Invalid DDD for phone number: {}", phone);
            return false;
        }

        if (!isValidPhoneNumber(phoneNumber)) {
            log.error("Invalid phone number format for: {}", phone);
            return false;
        }

        DDDValidator.Estado estado = DDDValidator.DDDS_ESTADOS.get(ddd);
        final var region = getRegiao(estado);
        log.info("Validating phone number: {} with DDD: {} from region: {}", phone, ddd, region);

        log.info("Phone validation successful for: {}, Estado: {}, Regiao: {}", phone, estado, region);
        return true;
    }

    private static boolean isValidDDD(final String ddd) {
        log.info("Validating DDD: {}", ddd);
        return DDDValidator.DDDS_ESTADOS.containsKey(ddd);
    }

    private static String getRegiao(DDDValidator.Estado estado) {
        log.info("Getting region for state: {}", estado);
        return switch (estado) {
            case DISTRITO_FEDERAL, GOIAS, MATO_GROSSO, MATO_GROSSO_DO_SUL -> "CENTRO-OESTE";
            case ALAGOAS, BAHIA, CEARA, MARANHAO, PARAIBA, PERNAMBUCO, PIAUI, RIO_GRANDE_DO_NORTE, SERGIPE ->
                    "NORDESTE";
            case ACRE, AMAPA, AMAZONAS, PARA, RONDONIA, RORAIMA, TOCANTINS -> "NORTE";
            case ESPIRITO_SANTO, MINAS_GERAIS, RIO_DE_JANEIRO, SAO_PAULO -> "SUDESTE";
            case PARANA, RIO_GRANDE_DO_SUL, SANTA_CATARINA -> "SUL";
        };
    }

    private static boolean isValidPhoneNumber(final String phoneNumber) {
        log.info("Validating phone number format: {}", phoneNumber);
        final var phonePattern = "^\\d{4,5}-?\\d{4}$";
        log.info("Phone number format validation result: {}", phoneNumber);
        return Pattern.matches(phonePattern, phoneNumber);
    }

    public static String generateValidPhone() {
        log.info("Starting phone number generation");

        final var phoneNumber = new StringBuilder();

        log.info("Generating random DDD for phone number");
        final var ddds = DDDValidator.DDDS_ESTADOS.keySet().toArray(new String[0]);
        final var dddIndex = rnd.nextInt(ddds.length);
        final var ddd = ddds[dddIndex];
        final var dddDigits = ddd.split("\\|");
        final var selectedDdd = dddDigits[rnd.nextInt(dddDigits.length)];
        log.info("Generated DDD: {}", selectedDdd);

        phoneNumber.append(selectedDdd);

        log.info("Adding number 9 to phone number: {}", phoneNumber);
        phoneNumber.append(9);

        log.info("Generating random phone number digits");
        for (int i = 0; i < 8; i++) {
            phoneNumber.append(rnd.nextInt(10));
        }

        log.info("Generated phone number: {}", phoneNumber);
        return phoneNumber.toString();
    }

}
