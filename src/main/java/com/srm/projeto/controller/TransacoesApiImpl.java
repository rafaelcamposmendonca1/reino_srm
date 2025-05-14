package com.srm.projeto.controller;

import com.srm.projeto.api.TransacoesApi;
import com.srm.projeto.model.TransacaoInput;
import com.srm.projeto.model.TransacaoOutput;
import com.srm.projeto.service.TransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class TransacoesApiImpl implements TransacoesApi {

    private final TransacaoService transacaoService;

    @Override
    public ResponseEntity<List<TransacaoOutput>> _transacoesGet() {
        return null;
    }

    @Override
    public ResponseEntity<TransacaoOutput> _transacoesPost(TransacaoInput transacaoInput) {
        return null;
    }
}
