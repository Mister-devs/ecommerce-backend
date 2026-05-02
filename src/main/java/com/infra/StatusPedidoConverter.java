package com.infra;

import com.domains.enums.StatusPedido;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class StatusPedidoConverter implements AttributeConverter<StatusPedido, Integer> {

    @Override
    public Integer convertToDatabaseColumn(StatusPedido status) {
        return status == null ? null : status.getId();
    }

    @Override
    public StatusPedido convertToEntityAttribute(Integer dbValue) {
        return StatusPedido.toEnum(dbValue);
    }
}
