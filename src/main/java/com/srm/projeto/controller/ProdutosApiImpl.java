package com.srm.projeto.controller;

import com.srm.projeto.api.ProdutosApi;
import com.srm.projeto.model.ProdutoInput;
import com.srm.projeto.model.ProdutoOutput;
import com.srm.projeto.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
public class ProdutosApiImpl implements ProdutosApi {

    private final ProdutoService produtoService;

    @Override
    public ResponseEntity<List<ProdutoOutput>> _produtosGet() {
        return new ResponseEntity<>(produtoService.findAll(), OK);
    }

    @Override
    public ResponseEntity<ProdutoOutput> _produtosIdGet(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<ProdutoOutput> _produtosPost(ProdutoInput produtoInput) {
        return new ResponseEntity<>(produtoService.save(produtoInput), CREATED);
    }
}
