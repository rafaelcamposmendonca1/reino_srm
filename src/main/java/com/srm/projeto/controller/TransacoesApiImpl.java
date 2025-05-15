package com.srm.projeto.controller;

import com.srm.projeto.api.TransacoesApi;
import com.srm.projeto.model.TransacaoFiltedOutput;
import com.srm.projeto.model.TransacaoFiltroInput;
import com.srm.projeto.model.TransacaoInput;
import com.srm.projeto.model.TransacaoOutput;
import com.srm.projeto.service.TransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
public class TransacoesApiImpl implements TransacoesApi {

    private final TransacaoService transacaoService;


    @Override
    public ResponseEntity<TransacaoFiltedOutput> _transacoesFiltrarGet(Optional<Long> moedaProdutoId, Optional<Long> moedaTransacaoId, Optional<String> reinoTransacao, Optional<String> reinoOrigem, Optional<OffsetDateTime> dataTransacao) {
        TransacaoFiltroInput filtro = new TransacaoFiltroInput();
        moedaProdutoId.ifPresent(filtro::setMoedaProdutoId);
        moedaTransacaoId.ifPresent(filtro::setMoedaTransacaoId);
        reinoTransacao.ifPresent(filtro::setReinoTransacao);
        dataTransacao.ifPresent(filtro::setDataTransacao);

        List<TransacaoOutput> transacoes = transacaoService.findWithFilter(filtro);

        TransacaoFiltedOutput response = new TransacaoFiltedOutput();
        response.setContent(transacoes);
        response.setTotalElements(transacoes.size());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<TransacaoOutput>> _transacoesGet() {
        return new ResponseEntity<>(transacaoService.findAll() ,OK);
    }

    @Override
    public ResponseEntity<TransacaoOutput> _transacoesPost(TransacaoInput transacaoInput) {
        return new ResponseEntity<>(transacaoService.save(transacaoInput) ,CREATED);
    }

}
