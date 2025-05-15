package com.srm.projeto.mapper.helper;

import org.mapstruct.Named;
import com.srm.projeto.entity.Moeda;
import com.srm.projeto.repository.MoedaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class MoedaTransacaoMapperHelper {

    private final MoedaRepository moedaRepository;

    @Named("mapMoedaTransacao")
    public Moeda map(Long id) {
        return moedaRepository.findById(id).orElseThrow(() -> new RuntimeException("Moeda 2 nao encontrada"));
    }
}