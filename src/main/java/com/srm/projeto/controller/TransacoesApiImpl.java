package com.srm.projeto.controller;

import com.srm.projeto.api.TransacoesApi;
import com.srm.projeto.model.TransacaoInput;
import com.srm.projeto.model.TransacaoOutput;
import com.srm.projeto.service.TransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
public class TransacoesApiImpl implements TransacoesApi {

    private final TransacaoService transacaoService;

    @Override
    public ResponseEntity<List<TransacaoOutput>> _transacoesGet() {
        return new ResponseEntity<>(transacaoService.findAll() ,OK);
    }

    @Override
    public ResponseEntity<TransacaoOutput> _transacoesPost(TransacaoInput transacaoInput) {
        return new ResponseEntity<>(transacaoService.save(transacaoInput) ,CREATED);
    }
}
