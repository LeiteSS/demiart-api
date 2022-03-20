package io.github.demiart.api.Services;

import io.github.demiart.api.Business.dto.DisciplineDTO;
import io.github.demiart.api.Business.dto.MaterialDTO;
import io.github.demiart.api.Exceptions.DisciplineAlreadyExistsException;
import io.github.demiart.api.Exceptions.DisciplineNotFoundException;
import io.github.demiart.api.Repository.model.MaterialModel;

import java.util.List;

public interface DisciplinesService
{
    DisciplineDTO create(DisciplineDTO disciplineDTO) throws DisciplineAlreadyExistsException;

    DisciplineDTO findByName(String disciplineName) throws DisciplineNotFoundException;

    List<DisciplineDTO> listAll();

    DisciplineDTO updateById(Long id, DisciplineDTO disciplineDTO) throws DisciplineNotFoundException;

    void deleteById(Long id) throws DisciplineNotFoundException;

    List<MaterialModel> findMaterial(Long id);
}
