package com.srm.projeto.enun;

import lombok.Getter;

@Getter
public enum Qualidade {
    RUIM("Ruim"),
    MEDIA("Media"),
    BOA("Boa"),
    OTIMA("Otima");

    private final String descricao;

    Qualidade(String descricao) {
        this.descricao = descricao;
    }
}
