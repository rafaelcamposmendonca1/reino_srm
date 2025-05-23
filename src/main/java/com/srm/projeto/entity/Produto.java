package com.srm.projeto.entity;

import com.srm.projeto.enun.Qualidade;
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

    @Enumerated(EnumType.STRING)
    private Qualidade qualidade;

    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "reino_origem_id", nullable = false)
    private Reino reinoOrigem;

}
