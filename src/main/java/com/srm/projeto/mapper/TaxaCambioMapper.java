package com.srm.projeto.mapper;

import com.srm.projeto.entity.TaxaCambio;
import com.srm.projeto.model.TaxaCambioInput;
import com.srm.projeto.model.TaxaCambioOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = MoedaMapper.class)
public interface TaxaCambioMapper {

    @Mapping(source = "moedaOrigemId", target = "moedaOrigem.id")
    @Mapping(source = "moedaDestinoId", target = "moedaDestino.id")
    TaxaCambio taxaCambioInputToTaxaCambio(TaxaCambioInput input);
    TaxaCambioOutput taxaCambioToTaxaCambioOutput(TaxaCambio entity);

}
