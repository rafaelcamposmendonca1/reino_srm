package com.srm.projeto.entity;

import com.srm.projeto.model.Moeda;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moeda")
public class MoedaEntity extends Moeda {

    public MoedaEntity() {
    }

    @Override
    @Id
    public Integer getId() {
        return super.getId();
    }
}