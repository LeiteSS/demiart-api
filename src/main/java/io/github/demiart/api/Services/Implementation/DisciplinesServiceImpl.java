package io.github.demiart.api.Services.Implementation;

import io.github.demiart.api.Business.dto.DisciplineDTO;
import io.github.demiart.api.Business.dto.MaterialDTO;
import io.github.demiart.api.Exceptions.DisciplineAlreadyExistsException;
import io.github.demiart.api.Exceptions.DisciplineNotFoundException;
import io.github.demiart.api.Mappers.DisciplinesMapper;
import io.github.demiart.api.Mappers.MaterialsMapper;
import io.github.demiart.api.Models.Discipline;
import io.github.demiart.api.Repository.DisciplinesRepository;
import io.github.demiart.api.Repository.MaterialsRepository;
import io.github.demiart.api.Repository.model.MaterialModel;
import io.github.demiart.api.Services.DisciplinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DisciplinesServiceImpl implements DisciplinesService
{
    @Autowired
    private DisciplinesRepository disciplinesRepository;

    @Autowired
    private MaterialsRepository materialsRepository;

    @Autowired
    private final DisciplinesMapper disciplinesMapper = DisciplinesMapper.INSTANCE;

    @Autowired
    private final MaterialsMapper materialsMapper = MaterialsMapper.INSTANCE;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public DisciplineDTO create(DisciplineDTO disciplineDTO) throws DisciplineAlreadyExistsException
    {
        verifyIfAlreadyWasCreated(disciplineDTO.getDisciplineName());

        Discipline discipline = objectMapper.convertValue(disciplineDTO, Discipline.class);
        Discipline disciplineSave = disciplinesRepository.save(discipline);

        return disciplinesMapper.toDTO(disciplineSave);
    }

    @Override
    public DisciplineDTO findByName(String disciplineName) throws DisciplineNotFoundException
    {
        Discipline disciplineFounded = findDisciplineByName(disciplineName);

        return disciplinesMapper.toDTO(disciplineFounded);
    }

    @Override
    public List<MaterialModel> findMaterial(Long id)
    {
        return materialsRepository.findByDisciplineId(id);
    }

    @Override
    public List<DisciplineDTO> listAll() {
        return disciplinesRepository.findAll()
                .stream()
                .map(disciplinesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DisciplineDTO updateById(Long id, DisciplineDTO disciplineDTO) throws DisciplineNotFoundException {
        verifyIfExists(id);

        Discipline disciplineToUpdate = objectMapper.convertValue(disciplineDTO, Discipline.class);
        disciplineToUpdate.setId(id);
        Discipline updatedDiscipline = disciplinesRepository.save(disciplineToUpdate);

        return disciplinesMapper.toDTO(updatedDiscipline);
    }

    @Override
    public void deleteById(Long id) throws DisciplineNotFoundException {
        verifyIfExists(id);
        disciplinesRepository.deleteById(id);
    }

    private void verifyIfAlreadyWasCreated(String disciplineName) throws DisciplineAlreadyExistsException
    {
        Optional<Discipline> optSavedDiscipline = disciplinesRepository.findByDisciplineName(disciplineName);

        if(optSavedDiscipline.isPresent())
        {
            throw new DisciplineAlreadyExistsException(disciplineName);
        }
    }

    private Discipline verifyIfExists(Long id) throws DisciplineNotFoundException
    {
        return disciplinesRepository.findById(id)
                .orElseThrow(() -> new DisciplineNotFoundException(id));
    }


    private Discipline findDisciplineByName(String disciplineName) throws DisciplineNotFoundException {
        return disciplinesRepository.findByDisciplineName(disciplineName)
                .orElseThrow(() -> new DisciplineNotFoundException(disciplineName));
    }
}
