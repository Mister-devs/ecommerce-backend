package com.services;

import com.domains.enums.TipoFrete;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class FreteService {

    public BigDecimal calcular(TipoFrete tipo, BigDecimal valor) {

        return switch (tipo) {
            case AEREO -> valor.multiply(new BigDecimal("0.10")).setScale(2, RoundingMode.HALF_UP);
            case TERRESTRE -> valor.multiply(new BigDecimal("0.05")).setScale(2, RoundingMode.HALF_UP);
        };
    }

}