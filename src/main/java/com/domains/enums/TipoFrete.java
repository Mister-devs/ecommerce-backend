package com.domains.enums;

public enum TipoFrete {

    TERRESTRE(0, "TERRESTRE"),
    AEREO(1, "AEREO");

    private Integer id;
    private String descricao;

    TipoFrete(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoFrete toEnum(Integer id) {
        if (id == null) return null;

        for (TipoFrete tipo : TipoFrete.values()) {
            if (id.equals(tipo.getId())) {
                return tipo;
            }
        }

        throw new IllegalArgumentException("TipoFrete inválido!");
    }
}
