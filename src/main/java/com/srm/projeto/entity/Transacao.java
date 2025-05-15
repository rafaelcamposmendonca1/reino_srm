package com.srm.projeto.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @OneToOne
    @JoinColumn(name = "moeda_produto_id")
    private Moeda moedaProduto;

    @OneToOne
    @JoinColumn(name = "moeda_transacao_id")
    private Moeda moedaTransacao;

    private Integer quantidade;

    private Double valorProduto;

    private Double valorConvertido;

    private Double valorTotalConvertido;

    private Double valorTotalConvertidoTaxa;

    private Double taxa;

    @ManyToOne
    @JoinColumn(name = "reino_transacao_id", nullable = false)
    private Reino reinoTransacao;

    private OffsetDateTime dataTransacao;

}
