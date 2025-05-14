package com.srm.projeto.controller;

import com.srm.projeto.api.TaxaCambioApi;
import com.srm.projeto.model.TaxaCambioInput;
import com.srm.projeto.model.TaxaCambioOutput;
import com.srm.projeto.model.TaxaCambioUpdate;
import com.srm.projeto.service.TaxaCambioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
public class TaxaCambioApiImpl implements TaxaCambioApi {

    private final TaxaCambioService taxaCambioService;

    @Override
    public ResponseEntity<List<TaxaCambioOutput>> _taxasCambioGet() {
        return new ResponseEntity<>(taxaCambioService.findAll() ,CREATED);
    }

    @Override
    public ResponseEntity<TaxaCambioOutput> _taxasCambioIdPut(Long id, TaxaCambioUpdate taxaCambioUpdate) {
        return new ResponseEntity<>(taxaCambioService.update(id, taxaCambioUpdate) ,OK);
    }

    @Override
    public ResponseEntity<TaxaCambioOutput> _taxasCambioPost(TaxaCambioInput taxaCambioInput) {
        return null;
    }
}
