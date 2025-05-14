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
    @JoinColumn(name = "moeda_id")
    private Moeda moeda;

    private Double valorOriginal;

    private Double valorConvertido;

    private Double valorTotalConvertido;

    private Integer quantidade;

    private LocalDateTime data_transacao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "reino_origem_id", nullable = false)
    private Reino reinoOrigem;

}
