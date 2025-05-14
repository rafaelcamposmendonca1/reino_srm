package com.srm.projeto.controller;

import com.srm.projeto.api.MoedasApi;
import com.srm.projeto.model.MoedaInput;
import com.srm.projeto.model.MoedaOutput;
import com.srm.projeto.model.TaxaCambioInput;
import com.srm.projeto.model.TaxaCambioOutput;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class MoedasApiImpl implements MoedasApi {
    @Override
    public ResponseEntity<List<MoedaOutput>> _moedasGet() {
        return null;
    }

    @Override
    public ResponseEntity<MoedaOutput> _moedasPost(MoedaInput moedaInput) {
        return null;
    }

    @Override
    public ResponseEntity<TaxaCambioOutput> _taxasCambioGet() {
        return null;
    }

    @Override
    public ResponseEntity<TaxaCambioOutput> _taxasCambioPost(TaxaCambioInput taxaCambioInput) {
        return null;
    }
}
