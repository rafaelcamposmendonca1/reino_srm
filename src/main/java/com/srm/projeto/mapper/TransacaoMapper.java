package com.srm.projeto.mapper;

import com.srm.projeto.entity.Transacao;
import com.srm.projeto.model.TransacaoInput;
import com.srm.projeto.model.TransacaoOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProdutoMapper.class, MoedaMapper.class, ReinoMapperHelper.class})
public interface TransacaoMapper {

    List<TransacaoOutput> transacaoListToTransacaoOutputList(List<Transacao> transacaoList);
    TransacaoOutput transacaoToTransacaoOutput(Transacao transacao);
    @Mapping(source = "reinoOrigem", target = "reinoOrigem")
    Transacao transacaoInputToTransacao(TransacaoInput transacaoInput);
}
