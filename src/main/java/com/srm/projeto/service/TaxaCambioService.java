package com.srm.projeto.service;

import com.srm.projeto.entity.TaxaCambio;
import com.srm.projeto.repository.TaxaCambioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TaxaCambioService {

    private final TaxaCambioRepository repository;


    public void update(){
       // taxaCambioRepository.findById()
        //taxaCambioRepository.save()
    }
}
