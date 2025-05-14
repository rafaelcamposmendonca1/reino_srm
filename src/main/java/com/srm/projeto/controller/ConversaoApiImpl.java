package com.srm.projeto.controller;

import com.srm.projeto.api.ConversaoApi;
import com.srm.projeto.model.ConversaoInput;
import com.srm.projeto.model.ResultadoConversao;
import com.srm.projeto.model.Transacao;
import com.srm.projeto.model.TransacaoInput;
import com.srm.projeto.service.MoedaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ConversaoApiImpl implements ConversaoApi {

    private final MoedaService moedaService;

    @Override
    public ResponseEntity<ResultadoConversao> _conversaoPost(ConversaoInput conversaoInput) {
        return moedaService.salvar();
    }

    @Override
    public ResponseEntity<List<Transacao>> _transacoesGet() {
        return null;
    }

    @Override
    public ResponseEntity<Transacao> _transacoesPost(TransacaoInput transacaoInput) {
        return null;
    }
}
