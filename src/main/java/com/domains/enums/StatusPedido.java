package com.domains.enums;

public enum StatusPedido {
    AGUARDANDO(0, "AGUARDANDO"),
    PAGO(1, "PAGO"),
    ENVIADO(2, "ENVIADO"),
    CANCELADO(3, "CANCELADO");

    private Integer id;
    private String descricao;

    StatusPedido(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusPedido toEnum(Integer id) {
        if (id == null) return null;

        for (StatusPedido status : StatusPedido.values()) {
            if (id.equals(status.getId())) {
                return status;
            }
        }

        throw new IllegalArgumentException("StatusPedido inválido!");
    }
}
