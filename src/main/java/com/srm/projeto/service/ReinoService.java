package com.srm.projeto.service;

import com.srm.projeto.mapper.ReinoMapper;
import com.srm.projeto.model.ReinoOutput;
import com.srm.projeto.repository.ReinoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ReinoService {

    private final ReinoRepository repository;
    private final ReinoMapper mapper;

    public List<ReinoOutput> findAll(){
        return mapper.reinoToReinoOutput(repository.findAll());
    }
}
