package com.srm.projeto.mapper;

import com.srm.projeto.entity.Transacao;
import com.srm.projeto.mapper.helper.MoedaProdutoMapperHelper;
import com.srm.projeto.mapper.helper.MoedaTransacaoMapperHelper;
import com.srm.projeto.mapper.helper.ProdutoMapperHelper;
import com.srm.projeto.mapper.helper.ReinoMapperHelper;
import com.srm.projeto.model.TransacaoInput;
import com.srm.projeto.model.TransacaoOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {
                ProdutoMapper.class,
                ReinoMapperHelper.class,
                ProdutoMapperHelper.class,
                MoedaTransacaoMapperHelper.class,
                MoedaProdutoMapperHelper.class,
        })
public interface TransacaoMapper {

    List<TransacaoOutput> transacaoListToTransacaoOutputList(List<Transacao> transacaoList);
    TransacaoOutput transacaoToTransacaoOutput(Transacao transacao);

    @Mapping(source = "produtoId", target = "produto")
    @Mapping(source = "moedaProdutoId", target = "moedaProduto", qualifiedByName = "mapMoedaProduto")
    @Mapping(source = "moedaTransacaoId", target = "moedaTransacao", qualifiedByName = "mapMoedaTransacao")
    @Mapping(source = "reinoTransacao", target = "reinoTransacao")
    Transacao transacaoInputToTransacao(TransacaoInput transacaoInput);
}
