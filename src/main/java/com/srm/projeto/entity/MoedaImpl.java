package com.srm.projeto.entity;

import com.srm.projeto.model.Moeda;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moeda")
public class MoedaImpl extends Moeda {
    public MoedaImpl() {
    }

    @Override
    @Id
    public Integer getId() {
        return super.getId();
    }
}
