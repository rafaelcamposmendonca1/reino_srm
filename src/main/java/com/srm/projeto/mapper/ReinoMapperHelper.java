package com.srm.projeto.mapper;

import com.srm.projeto.entity.Reino;
import com.srm.projeto.repository.ReinoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ReinoMapperHelper {

    private final ReinoRepository repository;

    public Reino map(String name) {
        return repository.findByNome(name).orElseThrow( () -> new RuntimeException("nao encontrando"));
    }
}
