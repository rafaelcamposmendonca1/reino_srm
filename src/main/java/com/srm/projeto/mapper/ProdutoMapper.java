package com.srm.projeto.mapper;

import com.srm.projeto.entity.Produto;
import com.srm.projeto.model.ProdutoInput;
import com.srm.projeto.model.ProdutoOutput;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    Produto produtoInputToProduto(ProdutoInput input);
    ProdutoOutput produtoToProdutoOutput(Produto produto);

    List<ProdutoOutput> produtoListToProdutoOutputList(List<Produto> produtoList);
}
