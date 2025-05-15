package com.srm.projeto.service;

import com.srm.projeto.entity.TaxaCambio;
import com.srm.projeto.mapper.TaxaCambioMapper;
import com.srm.projeto.model.TaxaCambioInput;
import com.srm.projeto.model.TaxaCambioOutput;
import com.srm.projeto.model.TaxaCambioUpdate;
import com.srm.projeto.repository.MoedaRepository;
import com.srm.projeto.repository.TaxaCambioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class TaxaCambioService {

    private final TaxaCambioRepository repository;
    private final MoedaRepository moedaRepository;
    private final TaxaCambioMapper mapper;

    public List<TaxaCambioOutput> findAll() {
        return mapper.taxaCambioToTaxaCambioOutput(repository.findAll());
    }

    @Transactional
    public TaxaCambioOutput update(Long id, TaxaCambioUpdate taxaCambioUpdate) {
        validade(taxaCambioUpdate);
        TaxaCambio taxaCambio = repository.findById(id).orElseThrow(RuntimeException::new);

        taxaCambio.setTaxa(taxaCambioUpdate.getTaxa() != null ? taxaCambioUpdate.getTaxa() : taxaCambio.getTaxa());

        taxaCambio.setMoedaOrigem(taxaCambioUpdate.getMoedaOrigemId() != null ?
                moedaRepository.findById(taxaCambioUpdate.getMoedaOrigemId()).orElseThrow(RuntimeException::new)
                : taxaCambio.getMoedaOrigem());
        taxaCambio.setMoedaDestino(taxaCambioUpdate.getMoedaDestinoId() != null ?
                moedaRepository.findById(taxaCambioUpdate.getMoedaDestinoId()).orElseThrow(RuntimeException::new)
                : taxaCambio.getMoedaDestino());

        return mapper.taxaCambioToTaxaCambioOutput(
                repository.save(
                        taxaCambio
                )
        );
    }

    private void validade(TaxaCambioUpdate taxaCambioUpdate){
        if(taxaCambioUpdate.getMoedaOrigemId().equals(taxaCambioUpdate.getMoedaDestinoId())){
            throw new RuntimeException();
        }
    }

}
