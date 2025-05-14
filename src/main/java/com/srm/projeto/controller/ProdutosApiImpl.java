package com.srm.projeto.controller;

import com.srm.projeto.api.ProdutosApi;
import com.srm.projeto.model.Produto;
import com.srm.projeto.model.ProdutoInput;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ProdutosApiImpl implements ProdutosApi {
    @Override
    public ResponseEntity<List<Produto>> _produtosGet() {
        return null;
    }

    @Override
    public ResponseEntity<Produto> _produtosIdGet(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Produto> _produtosPost(ProdutoInput produtoInput) {
        return null;
    }
}
