package br.com.data.validation.util;

import java.util.HashMap;
import java.util.Map;

public class DDDValidator {

    static final Map<String, Estado> DDDS_ESTADOS = new HashMap<>();

    static {
        // CENTRO-OESTE
        DDDS_ESTADOS.put("61", Estado.DISTRITO_FEDERAL);
        DDDS_ESTADOS.put("62", Estado.GOIAS);
        DDDS_ESTADOS.put("64", Estado.GOIAS);
        DDDS_ESTADOS.put("65", Estado.MATO_GROSSO);
        DDDS_ESTADOS.put("66", Estado.MATO_GROSSO);
        DDDS_ESTADOS.put("67", Estado.MATO_GROSSO_DO_SUL);

        // NORDESTE
        DDDS_ESTADOS.put("82", Estado.ALAGOAS);
        DDDS_ESTADOS.put("71", Estado.BAHIA);
        DDDS_ESTADOS.put("73", Estado.BAHIA);
        DDDS_ESTADOS.put("74", Estado.BAHIA);
        DDDS_ESTADOS.put("75", Estado.BAHIA);
        DDDS_ESTADOS.put("77", Estado.BAHIA);
        DDDS_ESTADOS.put("85", Estado.CEARA);
        DDDS_ESTADOS.put("88", Estado.CEARA);
        DDDS_ESTADOS.put("98", Estado.MARANHAO);
        DDDS_ESTADOS.put("99", Estado.MARANHAO);
        DDDS_ESTADOS.put("83", Estado.PARAIBA);
        DDDS_ESTADOS.put("81", Estado.PERNAMBUCO);
        DDDS_ESTADOS.put("87", Estado.PERNAMBUCO);
        DDDS_ESTADOS.put("86", Estado.PIAUI);
        DDDS_ESTADOS.put("89", Estado.PIAUI);
        DDDS_ESTADOS.put("84", Estado.RIO_GRANDE_DO_NORTE);
        DDDS_ESTADOS.put("79", Estado.SERGIPE);

        // NORTE
        DDDS_ESTADOS.put("68", Estado.ACRE);
        DDDS_ESTADOS.put("96", Estado.AMAPA);
        DDDS_ESTADOS.put("92", Estado.AMAZONAS);
        DDDS_ESTADOS.put("97", Estado.AMAZONAS);
        DDDS_ESTADOS.put("91", Estado.PARA);
        DDDS_ESTADOS.put("93", Estado.PARA);
        DDDS_ESTADOS.put("94", Estado.PARA);
        DDDS_ESTADOS.put("69", Estado.RONDONIA);
        DDDS_ESTADOS.put("95", Estado.RORAIMA);
        DDDS_ESTADOS.put("63", Estado.TOCANTINS);

        // SUDESTE
        DDDS_ESTADOS.put("27", Estado.ESPIRITO_SANTO);
        DDDS_ESTADOS.put("28", Estado.ESPIRITO_SANTO);
        DDDS_ESTADOS.put("31", Estado.MINAS_GERAIS);
        DDDS_ESTADOS.put("32", Estado.MINAS_GERAIS);
        DDDS_ESTADOS.put("33", Estado.MINAS_GERAIS);
        DDDS_ESTADOS.put("34", Estado.MINAS_GERAIS);
        DDDS_ESTADOS.put("35", Estado.MINAS_GERAIS);
        DDDS_ESTADOS.put("37", Estado.MINAS_GERAIS);
        DDDS_ESTADOS.put("38", Estado.MINAS_GERAIS);
        DDDS_ESTADOS.put("21", Estado.RIO_DE_JANEIRO);
        DDDS_ESTADOS.put("22", Estado.RIO_DE_JANEIRO);
        DDDS_ESTADOS.put("24", Estado.RIO_DE_JANEIRO);
        DDDS_ESTADOS.put("11", Estado.SAO_PAULO);
        DDDS_ESTADOS.put("12", Estado.SAO_PAULO);
        DDDS_ESTADOS.put("13", Estado.SAO_PAULO);
        DDDS_ESTADOS.put("14", Estado.SAO_PAULO);
        DDDS_ESTADOS.put("15", Estado.SAO_PAULO);
        DDDS_ESTADOS.put("16", Estado.SAO_PAULO);
        DDDS_ESTADOS.put("17", Estado.SAO_PAULO);
        DDDS_ESTADOS.put("18", Estado.SAO_PAULO);
        DDDS_ESTADOS.put("19", Estado.SAO_PAULO);

        // SUL
        DDDS_ESTADOS.put("41", Estado.PARANA);
        DDDS_ESTADOS.put("42", Estado.PARANA);
        DDDS_ESTADOS.put("43", Estado.PARANA);
        DDDS_ESTADOS.put("44", Estado.PARANA);
        DDDS_ESTADOS.put("45", Estado.PARANA);
        DDDS_ESTADOS.put("46", Estado.PARANA);
        DDDS_ESTADOS.put("51", Estado.RIO_GRANDE_DO_SUL);
        DDDS_ESTADOS.put("53", Estado.RIO_GRANDE_DO_SUL);
        DDDS_ESTADOS.put("54", Estado.RIO_GRANDE_DO_SUL);
        DDDS_ESTADOS.put("55", Estado.RIO_GRANDE_DO_SUL);
        DDDS_ESTADOS.put("47", Estado.SANTA_CATARINA);
        DDDS_ESTADOS.put("48", Estado.SANTA_CATARINA);
        DDDS_ESTADOS.put("49", Estado.SANTA_CATARINA);
    }

    public enum Estado {
        // CENTRO-OESTE
        DISTRITO_FEDERAL, GOIAS, MATO_GROSSO, MATO_GROSSO_DO_SUL,

        // NORDESTE
        ALAGOAS, BAHIA, CEARA, MARANHAO, PARAIBA, PERNAMBUCO, PIAUI, RIO_GRANDE_DO_NORTE, SERGIPE,

        // NORTE
        ACRE, AMAPA, AMAZONAS, PARA, RONDONIA, RORAIMA, TOCANTINS,

        // SUDESTE
        ESPIRITO_SANTO, MINAS_GERAIS, RIO_DE_JANEIRO, SAO_PAULO,

        // SUL
        PARANA, RIO_GRANDE_DO_SUL, SANTA_CATARINA
    }
}
