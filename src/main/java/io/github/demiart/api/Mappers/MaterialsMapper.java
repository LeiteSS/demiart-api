package io.github.demiart.api.Mappers;

import io.github.demiart.api.Business.dto.MaterialDTO;
import io.github.demiart.api.Models.Material;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MaterialsMapper
{
    MaterialsMapper INSTANCE = Mappers.getMapper(MaterialsMapper.class);

    Material toModel(MaterialDTO dto);

    MaterialDTO toDTO(Material model);
}
