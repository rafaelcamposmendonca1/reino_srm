package com.srm.projeto.mapper;

import com.srm.projeto.entity.Reino;
import com.srm.projeto.model.ReinoOutput;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReinoMapper {
    List<ReinoOutput> reinoToReinoOutput(List<Reino> reino);
}
