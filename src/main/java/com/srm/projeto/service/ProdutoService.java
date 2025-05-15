package com.srm.projeto.service;

import com.srm.projeto.mapper.ProdutoMapper;
import com.srm.projeto.model.ProdutoInput;
import com.srm.projeto.model.ProdutoOutput;
import com.srm.projeto.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoOutput save(ProdutoInput produtoInput){
        return mapper.produtoToProdutoOutput(repository.save(mapper.produtoInputToProduto(produtoInput)));
    }

    public List<ProdutoOutput> findAll(){
        return mapper.produtoListToProdutoOutputList(repository.findAll());
    };
}
