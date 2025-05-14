package com.srm.projeto.controller;

import com.srm.projeto.api.TaxaCambioApi;
import com.srm.projeto.model.TaxaCambioInput;
import com.srm.projeto.model.TaxaCambioOutput;
import com.srm.projeto.model.TaxaCambioUpdate;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class TaxaCambioApiImpl implements TaxaCambioApi {
    @Override
    public ResponseEntity<List<TaxaCambioOutput>> _taxasCambioGet() {
        return null;
    }

    @Override
    public ResponseEntity<TaxaCambioOutput> _taxasCambioIdPut(Integer id, TaxaCambioUpdate taxaCambioUpdate) {
        return null;
    }

    @Override
    public ResponseEntity<TaxaCambioOutput> _taxasCambioPost(TaxaCambioInput taxaCambioInput) {
        return null;
    }
}
