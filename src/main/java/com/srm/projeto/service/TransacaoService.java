package com.srm.projeto.service;

import com.srm.projeto.entity.TaxaCambio;
import com.srm.projeto.entity.Transacao;
import com.srm.projeto.mapper.TransacaoMapper;
import com.srm.projeto.model.TransacaoInput;
import com.srm.projeto.model.TransacaoOutput;
import com.srm.projeto.repository.ProdutoRepository;
import com.srm.projeto.repository.TaxaCambioRepository;
import com.srm.projeto.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class TransacaoService {

    private final TransacaoRepository repository;
    private final TaxaCambioRepository taxaCambioRepository;
    private final TransacaoMapper mapper;

    public TransacaoOutput save(TransacaoInput transacaoInput) {

        Transacao transacao = mapper.transacaoInputToTransacao(transacaoInput);

        TaxaCambio exchangeValues = taxaCambioRepository.findByMoedaOrigemAndMoedaDestino(
                        transacaoInput.getMoedaProdutoId(), transacaoInput.getMoedaTransacaoId())
                .orElseThrow(() -> new RuntimeException("Taxa de câmbio não encontrada"));

        TaxaCambio exchangeTax = taxaCambioRepository.findByMoedaDestinoAndMoedaOrigem(
                        transacaoInput.getMoedaTransacaoId(), transacaoInput.getMoedaProdutoId())
                .orElseThrow(() -> new RuntimeException("Taxa de câmbio não encontrada"));
        Double value = adjustProductValueBasedOnQuality(transacaoInput.getValorProduto(), transacao.getProduto().getQualidade().getDescricao());
        value = (value * transacao.getProduto().getReinoOrigem().getValorProdutoReino()) / 100;
        transacaoInput.setValorProduto(value);

        transacao.setValorConvertido(transacaoInput.getValorProduto() *  exchangeValues.getValorConvertido());
        transacao.setValorTotalConvertido((transacaoInput.getValorProduto() *  exchangeValues.getValorConvertido()) * transacaoInput.getQuantidade());

        Double tax = exchangeTax.getTaxa();

        Double additionalTax = transacao.getValorTotalConvertido() * (tax / 100);

        transacao.setValorTotalConvertidoTaxa(transacao.getValorTotalConvertido() + additionalTax);

        transacao.setDataTransacao(OffsetDateTime.now());

        transacao.setTaxa(tax);

        Transacao savedTransacao = repository.save(transacao);

        TransacaoOutput transacaoOutput = mapper.transacaoToTransacaoOutput(savedTransacao);

        transacaoOutput.setDataTransacao(savedTransacao.getDataTransacao());

        return transacaoOutput;
    }

    public List<TransacaoOutput> findAll() {
        return mapper.transacaoListToTransacaoOutputList(repository.findAll());
    }


    private Double adjustProductValueBasedOnQuality(Double productValue, String qualidade) {
        switch (qualidade) {
            case "ruim":
                return productValue * 0.90;
            case "media":
                return productValue;
            case "boa":
                return productValue * 1.10;
            case "otima":
                return productValue * 1.20;
            default:
                throw new IllegalArgumentException("Qualidade invalida");
        }
    }
}