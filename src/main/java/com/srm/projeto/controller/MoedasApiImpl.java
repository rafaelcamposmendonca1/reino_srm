package com.srm.projeto.controller;

import com.srm.projeto.api.MoedasApi;
import com.srm.projeto.model.MoedaInput;
import com.srm.projeto.model.MoedaOutput;
import com.srm.projeto.model.TaxaCambioInput;
import com.srm.projeto.model.TaxaCambioOutput;
import com.srm.projeto.service.MoedaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
public class MoedasApiImpl implements MoedasApi {

    private final MoedaService moedaService;

    @Override
    public ResponseEntity<List<MoedaOutput>> _moedasGet() {
        return new ResponseEntity<>(moedaService.findAll(), OK);
    }

    @Override
    public ResponseEntity<MoedaOutput> _moedasPost(MoedaInput moedaInput) {
        return new ResponseEntity<>(moedaService.save(moedaInput), CREATED);
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
