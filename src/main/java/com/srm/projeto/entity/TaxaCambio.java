package com.srm.projeto.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Entity
public class TaxaCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "moeda_origem_id")
    private Moeda moedaOrigem;

    @OneToOne
    @JoinColumn(name = "moeda_destino_id")
    private Moeda moedaDestino;

    private Double taxa;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private OffsetDateTime dataVigencia;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private OffsetDateTime dataCriacao;

}
