package com.srm.projeto.service;

import com.srm.projeto.entity.Moeda;
import com.srm.projeto.mapper.MoedaMapper;
import com.srm.projeto.model.MoedaInput;
import com.srm.projeto.model.MoedaOutput;
import com.srm.projeto.repository.MoedaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class MoedaService {

    private final MoedaRepository moedaRepository;
    private final MoedaMapper moedaMapper;

    @Transactional
    public MoedaOutput save(MoedaInput moedaInput){
        Moeda moeda = moedaMapper.moedaInputToMoeda(moedaInput);
        moedaRepository.save(moeda);
        return moedaMapper.moedaToMoedaOutput(moeda);
    };

    public List<MoedaOutput> findAll(){
        return moedaMapper.moedaListToMoedaOutputList(moedaRepository.findAll());
    };

}
