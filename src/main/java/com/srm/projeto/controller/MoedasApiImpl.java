package com.srm.projeto.controller;

import com.srm.projeto.api.MoedasApi;
import com.srm.projeto.model.ConversaoInput;
import com.srm.projeto.model.Moeda;
import com.srm.projeto.model.TaxaCambio;
import com.srm.projeto.model.TaxaCambioInput;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class MoedasApiImpl implements MoedasApi {
    @Override
    public ResponseEntity<List<Moeda>> _moedasGet() {
        return null;
    }

    @Override
    public ResponseEntity<Moeda> _moedasPost(ConversaoInput conversaoInput) {
        return null;
    }

    @Override
    public ResponseEntity<TaxaCambio> _taxasCambioGet() {
        return null;
    }

    @Override
    public ResponseEntity<TaxaCambio> _taxasCambioPost(TaxaCambioInput taxaCambioInput) {
        return null;
    }
}
