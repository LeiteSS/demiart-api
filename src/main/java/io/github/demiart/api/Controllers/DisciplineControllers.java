package io.github.demiart.api.Controllers;

import io.github.demiart.api.Business.dto.DisciplineDTO;
import io.github.demiart.api.Exceptions.DisciplineAlreadyExistsException;
import io.github.demiart.api.Exceptions.DisciplineNotFoundException;
import io.github.demiart.api.Repository.model.MaterialModel;
import io.github.demiart.api.Services.DisciplinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "https://demisart.netlify.app")
public class DisciplineControllers
{
    @Autowired
    private DisciplinesService service;

    @PostMapping("/disciplines")
    public DisciplineDTO create(@RequestBody @Valid DisciplineDTO disciplineDTO)
            throws DisciplineAlreadyExistsException
    {
        return service.create(disciplineDTO);
    }

    @DeleteMapping("/disciplines/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws DisciplineNotFoundException
    {
        service.deleteById(id);
    }

    @GetMapping("/disciplines/{disciplineName}")
    public DisciplineDTO findByDisciplineName(@PathVariable String disciplineName)
            throws DisciplineNotFoundException
    {
        return service.findByName(disciplineName);
    }

    @GetMapping("/disciplines/materials/{id}")
    public List<MaterialModel> findMaterialByDiscipline(@PathVariable Long id) {
        return service.findMaterial(id);
    }

    @GetMapping("/disciplines")
    public List<DisciplineDTO> listAll()
    {
        return service.listAll();
    }

    @PutMapping("/disciplines/{id}")
    public DisciplineDTO update(@PathVariable Long id, @RequestBody @Valid DisciplineDTO disciplineDTO)
            throws DisciplineNotFoundException
    {
        return service.updateById(id, disciplineDTO);
    }
}
