package com.srm.projeto.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nome;

    private String descricao;

    private Double preco;

    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "reino_origem_id", nullable = false)
    private Reino reinoOrigem;

}
