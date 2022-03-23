package io.github.demiart.api.Services;


import io.github.demiart.api.Business.dto.MaterialDTO;
import io.github.demiart.api.Exceptions.DisciplineNotFoundException;
import io.github.demiart.api.Exceptions.MaterialAlreadyExistsException;
import io.github.demiart.api.Exceptions.MaterialNotFoundException;
import io.github.demiart.api.Repository.model.MaterialModel;

import java.util.List;

public interface MaterialsService
{
    MaterialDTO create(Long disciplineId, MaterialDTO materialDTO) throws MaterialAlreadyExistsException, DisciplineNotFoundException;

    MaterialDTO findByName(String materialName) throws MaterialNotFoundException;

    List<MaterialDTO> listAll();

    MaterialDTO updateById(Long id, MaterialDTO materialDTO);

    //List<MaterialModel> detailDiscipline(Long id) throws MaterialNotFoundException;

    void deleteById(Long id);
}
