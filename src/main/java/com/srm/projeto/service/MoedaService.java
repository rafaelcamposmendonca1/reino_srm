package com.srm.projeto.service;

import com.srm.projeto.repository.MoedaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MoedaService {

    private final MoedaRepository moedaRepository;



}
