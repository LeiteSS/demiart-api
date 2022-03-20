package io.github.demiart.api.Services.Implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.demiart.api.Business.dto.MaterialDTO;
import io.github.demiart.api.Exceptions.DisciplineAlreadyExistsException;
import io.github.demiart.api.Exceptions.DisciplineNotFoundException;
import io.github.demiart.api.Exceptions.MaterialAlreadyExistsException;
import io.github.demiart.api.Exceptions.MaterialNotFoundException;
import io.github.demiart.api.Mappers.MaterialsMapper;
import io.github.demiart.api.Models.Discipline;
import io.github.demiart.api.Models.Material;
import io.github.demiart.api.Repository.DisciplinesRepository;
import io.github.demiart.api.Repository.MaterialsRepository;
import io.github.demiart.api.Repository.model.MaterialModel;
import io.github.demiart.api.Services.MaterialsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class MaterialsServiceImpl implements MaterialsService
{
    @Autowired
    private MaterialsRepository materialsRepository;

    @Autowired
    private DisciplinesRepository disciplinesRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private final MaterialsMapper materialsMapper = MaterialsMapper.INSTANCE;

    @Override
    public MaterialDTO create(Long disciplineId, MaterialDTO materialDTO)
            throws MaterialAlreadyExistsException, DisciplineNotFoundException
    {
        Discipline disciplineFounded = verifyIfDisciplineExists(disciplineId);
        verifyIfAlreadyWasCreated(materialDTO.getMaterialName());

        Material material = objectMapper.convertValue(materialDTO, Material.class);
        material.setDisciplineId(disciplineFounded.getId());
        Material materialSave = materialsRepository.save(material);

        return materialsMapper.toDTO(materialSave);
    }

    @Override
    public MaterialDTO findByName(String materialName) {
        return null;
    }

    @Override
    public List<MaterialDTO> listAll() {
        return materialsRepository.findAll()
                .stream()
                .map(materialsMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MaterialDTO updateById(Long id, MaterialDTO materialDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    private void verifyIfAlreadyWasCreated(String materialName) throws MaterialAlreadyExistsException
    {
        Optional<Material> optSavedDiscipline = materialsRepository.findByMaterialName(materialName);

        if(optSavedDiscipline.isPresent())
        {
            throw new MaterialAlreadyExistsException(materialName);
        }
    }

    private Material verifyIfExists(Long id) throws MaterialNotFoundException
    {
        return materialsRepository.findById(id)
                .orElseThrow(() -> new MaterialNotFoundException(id));
    }

    private Discipline verifyIfDisciplineExists(Long disciplineId) throws DisciplineNotFoundException
    {
        return disciplinesRepository.findById(disciplineId)
                .orElseThrow(() -> new DisciplineNotFoundException(disciplineId));
    }


    private Material findMaterialByName(String materialName) throws MaterialNotFoundException {
        return materialsRepository.findByMaterialName(materialName)
                .orElseThrow(() -> new MaterialNotFoundException(materialName));
    }
}
