package com.srm.projeto.service;

import com.srm.projeto.mapper.TransacaoMapper;
import com.srm.projeto.model.TransacaoInput;
import com.srm.projeto.model.TransacaoOutput;
import com.srm.projeto.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TransacaoService {

    private final TransacaoRepository repository;
    private final TransacaoMapper mapper;

    public TransacaoOutput save(TransacaoInput transacaoInput) {

        mapper.transacaoInputToTransacao(transacaoInput);

        return null;
    }

    public List<TransacaoOutput> findAll() {
        return mapper.transacaoListToTransacaoOutputList(repository.findAll());
    }
}
