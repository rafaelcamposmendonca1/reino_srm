package com.srm.projeto.controller;

import com.srm.projeto.api.TransacoesApi;
import com.srm.projeto.model.TransacaoInput;
import com.srm.projeto.model.TransacaoOutput;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TransacoesApiImpl implements TransacoesApi {
    @Override
    public ResponseEntity<List<TransacaoOutput>> _transacoesGet() {
        return null;
    }

    @Override
    public ResponseEntity<TransacaoOutput> _transacoesPost(TransacaoInput transacaoInput) {
        return null;
    }
}
