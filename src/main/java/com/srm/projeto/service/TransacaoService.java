package com.srm.projeto.service;

import com.srm.projeto.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TransacaoService {

    TransacaoRepository transacaoRepository;


}
