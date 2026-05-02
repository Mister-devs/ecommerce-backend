package com.services.strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FreteTerrestre implements FreteStrategy {

    @Override
    public BigDecimal calcular(BigDecimal valor) {
        return valor.multiply(new BigDecimal("0.05"));
    }
}
