package com.srm.projeto.enun;

import lombok.Getter;

@Getter
public enum Qualidade {
    RUIM("ruim"),
    MEDIA("media"),
    BOA("boa"),
    OTIMA("otima");

    private final String descricao;

    Qualidade(String descricao) {
        this.descricao = descricao;
    }
}
