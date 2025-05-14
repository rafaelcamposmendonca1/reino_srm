package com.srm.projeto.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity
public class Transacao {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @OneToOne
    @JoinColumn(name = "moeda_id")
    private Moeda moeda;

    private Double valorConvertido;

    private Integer quantidade;
}
