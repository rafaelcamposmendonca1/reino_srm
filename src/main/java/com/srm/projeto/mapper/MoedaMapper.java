package com.srm.projeto.mapper;

import com.srm.projeto.entity.Moeda;
import com.srm.projeto.model.MoedaInput;
import com.srm.projeto.model.MoedaOutput;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MoedaMapper {

    MoedaMapper INSTANCE = Mappers.getMapper(MoedaMapper.class);

    Moeda moedaInputToMoeda(MoedaInput moedaInput);

    MoedaOutput moedaToMoedaOutput(Moeda moeda);

    Moeda moedaOutputToMoeda(MoedaOutput moedaOutput);

    MoedaInput moedaToMoedaInput(Moeda moeda);

    List<MoedaOutput> moedaListToMoedaOutputList(List<Moeda> moedas);
}
