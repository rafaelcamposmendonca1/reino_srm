package com.srm.projeto.service;

import com.srm.projeto.entity.Produto;
import com.srm.projeto.mapper.ProdutoMapper;
import com.srm.projeto.model.MoedaOutput;
import com.srm.projeto.model.ProdutoInput;
import com.srm.projeto.model.ProdutoOutput;
import com.srm.projeto.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoOutput save(ProdutoInput produtoInput){
        Produto produto = produtoMapper.produtoInputToProduto(produtoInput);
        return produtoMapper.produtoToProdutoOutput(produtoRepository.save(produto));
    }

    public List<ProdutoOutput> findAll(){
        return produtoMapper.produtoListToProdutoOutputList(produtoRepository.findAll());
    };
}
