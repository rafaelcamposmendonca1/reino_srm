package com.srm.projeto.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "reino_transacao_id", nullable = false)
    private Reino reinoTransacao;

    private LocalDateTime data_transacao = LocalDateTime.now();

}
