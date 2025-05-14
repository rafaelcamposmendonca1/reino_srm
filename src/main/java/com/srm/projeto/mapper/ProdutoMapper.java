package com.srm.projeto.mapper;

import com.srm.projeto.entity.Produto;
import com.srm.projeto.model.ProdutoInput;
import com.srm.projeto.model.ProdutoOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ReinoMapperHelper.class, TransacaoMapperHelper.class})
public interface ProdutoMapper {

    ProdutoOutput produtoToProdutoOutput(Produto produto);
    List<ProdutoOutput> produtoListToProdutoOutputList(List<Produto> produtoList);
    @Mapping(source = "reinoOrigem", target = "reinoOrigem")
    @Mapping(target = "dataCriacao", expression = "java(TransacaoMapperHelper.dateTimeNow())")
    Produto produtoInputToProduto(ProdutoInput produtoInput);
}
