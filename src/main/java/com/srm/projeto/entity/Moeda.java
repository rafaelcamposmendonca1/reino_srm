package com.srm.projeto.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Moeda {

    @Id
    private Long Id;

    private String nome;

    private String simbolo;

    private String descricao;

}
