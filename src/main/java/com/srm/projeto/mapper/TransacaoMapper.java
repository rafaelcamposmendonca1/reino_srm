package com.srm.projeto.mapper;

import com.srm.projeto.entity.Transacao;
import com.srm.projeto.model.TransacaoInput;
import com.srm.projeto.model.TransacaoOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProdutoMapper.class, MoedaMapper.class})
public interface TransacaoMapper {

    TransacaoOutput transacaoToTransacaoOutput(Transacao entity);
}
