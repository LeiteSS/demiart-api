package io.github.demiart.api.Mappers;

import io.github.demiart.api.Business.dto.DisciplineDTO;
import io.github.demiart.api.Models.Discipline;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DisciplinesMapper
{
    DisciplinesMapper INSTANCE = Mappers.getMapper(DisciplinesMapper.class);

    Discipline toModel(DisciplineDTO dto);

    DisciplineDTO toDTO(Discipline model);
}
