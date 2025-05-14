package com.srm.projeto.mapper;

import com.srm.projeto.entity.TaxaCambio;
import com.srm.projeto.model.TaxaCambioInput;
import com.srm.projeto.model.TaxaCambioOutput;
import com.srm.projeto.model.TaxaCambioUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = MoedaMapper.class)
public interface TaxaCambioMapper {

    @Mapping(source = "moedaOrigemId", target = "moedaOrigem.id")
    @Mapping(source = "moedaDestinoId", target = "moedaDestino.id")
    TaxaCambio taxaCambioInputToTaxaCambio(TaxaCambioInput taxaCambioInput);
    TaxaCambioOutput taxaCambioToTaxaCambioOutput(TaxaCambio taxaCambio);

    List<TaxaCambioOutput> taxaCambioToTaxaCambioOutput(List<TaxaCambio> taxaCambioList);

    TaxaCambio taxaCambioUpdateToTaxaCambio(TaxaCambioUpdate taxaCambioUpdate);

}
