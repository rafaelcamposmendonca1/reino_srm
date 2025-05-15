package com.srm.projeto.mapper.helper;

import org.mapstruct.Named;
import com.srm.projeto.entity.Moeda;
import com.srm.projeto.repository.MoedaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class MoedaProdutoMapperHelper {

    private final MoedaRepository moedaRepository;

    @Named("mapMoedaProduto")
    public Moeda map(Long id) {
        return moedaRepository.findById(id).orElseThrow(() -> new RuntimeException("Moeda nao encontrada"));
    }
}