package com.srm.projeto.mapper.helper;

import com.srm.projeto.entity.Produto;
import com.srm.projeto.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProdutoMapperHelper {

    private final ProdutoRepository produtoRepository;

    public Produto map(Long id){
        return produtoRepository.findById(id).orElseThrow( () -> new RuntimeException("Produto nao encontrando"));
    }
}
