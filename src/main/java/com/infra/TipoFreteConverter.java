package com.infra;

import com.domains.enums.TipoFrete;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class TipoFreteConverter implements AttributeConverter<TipoFrete, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TipoFrete tipo) {
        return tipo == null ? null : tipo.getId();
    }

    @Override
    public TipoFrete convertToEntityAttribute(Integer dbValue) {
        return TipoFrete.toEnum(dbValue);
    }
}
