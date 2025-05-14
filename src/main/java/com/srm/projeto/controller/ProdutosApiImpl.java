package com.srm.projeto.controller;

import com.srm.projeto.api.ProdutosApi;
import com.srm.projeto.model.ProdutoInput;
import com.srm.projeto.model.ProdutoOutput;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ProdutosApiImpl implements ProdutosApi {
    @Override
    public ResponseEntity<List<ProdutoOutput>> _produtosGet() {
        return null;
    }

    @Override
    public ResponseEntity<ProdutoOutput> _produtosIdGet(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<ProdutoOutput> _produtosPost(ProdutoInput produtoInput) {
        return null;
    }
}
