package com.srm.projeto.service;

import com.srm.projeto.model.ResultadoConversao;
import com.srm.projeto.repository.MoedaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Service
@AllArgsConstructor
public class MoedaService {

    private final MoedaRepository moedaRepository;

    public void salvar(){
        ResultadoConversao resultadoConversao = new ResultadoConversao();

    }

}
