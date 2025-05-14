package com.srm.projeto.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Produto {

    @Id
    private Long Id;

    private String nome;

    private String descricao;

}
