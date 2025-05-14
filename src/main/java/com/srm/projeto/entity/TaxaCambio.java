package com.srm.projeto.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Data
@Entity
public class TaxaCambio {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "moeda_origem_id")
    private Moeda moedaOrigem;

    @OneToOne
    @JoinColumn(name = "moeda_destino_id")
    private Moeda moedaDestino;

    private Double taxa;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime dataVigencia;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime dataCriacao;

}
