package com.srm.projeto.mapper;

import com.srm.projeto.entity.Transacao;
import com.srm.projeto.model.TransacaoInput;
import com.srm.projeto.model.TransacaoOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProdutoMapper.class, MoedaMapper.class})
public interface TransacaoMapper {


    @Mapping(source = "produtoId", target = "produto.id")
    @Mapping(source = "moedaId", target = "moeda.id")
    Transacao transacaoInputToTransacao(TransacaoInput input);

    TransacaoOutput transacaoToTransacaoOutput(Transacao entity);
}
