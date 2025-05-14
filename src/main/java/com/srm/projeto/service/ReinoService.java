package com.srm.projeto.service;

import com.srm.projeto.repository.ReinoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.srm.projeto.entity.Reino;

@AllArgsConstructor
@Service
public class ReinoService {

    private final ReinoRepository reinoRepository;

    public Reino findByNome(String name) {
        return reinoRepository.findByNome(name).orElseThrow( () -> new RuntimeException("nao encontrando"));
    }

}
