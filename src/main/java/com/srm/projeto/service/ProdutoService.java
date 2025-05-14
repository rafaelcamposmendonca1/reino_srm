package com.srm.projeto.service;

import com.srm.projeto.entity.Produto;
import com.srm.projeto.entity.Reino;
import com.srm.projeto.mapper.ProdutoMapper;
import com.srm.projeto.model.ProdutoInput;
import com.srm.projeto.model.ProdutoOutput;
import com.srm.projeto.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;
    private final ReinoService reinoService;

    public ProdutoOutput save(ProdutoInput produtoInput){
        Reino reino = reinoService.findByNome(produtoInput.getReinoOrigem());
        Produto produto = Produto.builder()
                .nome(produtoInput.getNome())
                .descricao(produtoInput.getDescricao())
                .preco(produtoInput.getPreco())
                .reinoOrigem(reino)
                .dataCriacao(LocalDateTime.now())
                .build();
        return produtoMapper.produtoToProdutoOutput(produtoRepository.save(produto));
    }

    public List<ProdutoOutput> findAll(){
        return produtoMapper.produtoListToProdutoOutputList(produtoRepository.findAll());
    };
}
