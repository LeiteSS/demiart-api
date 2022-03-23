package io.github.demiart.api.Controllers;

import io.github.demiart.api.Business.dto.DisciplineDTO;
import io.github.demiart.api.Business.dto.MaterialDTO;
import io.github.demiart.api.Exceptions.DisciplineNotFoundException;
import io.github.demiart.api.Exceptions.MaterialAlreadyExistsException;
import io.github.demiart.api.Exceptions.MaterialNotFoundException;
import io.github.demiart.api.Services.MaterialsService;
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
@CrossOrigin("http://localhost:3000/")
public class MaterialsControllers {

    @Autowired
    public MaterialsService service;

    @PostMapping("/disciplines/{disciplineId}")
    public MaterialDTO create(@PathVariable Long disciplineId, @RequestBody @Valid MaterialDTO materialDTO) throws MaterialAlreadyExistsException, DisciplineNotFoundException {
        return service.create(disciplineId, materialDTO);
    }

    @GetMapping("/disciplines/{disciplineId}/materials/{materialName}")
    public MaterialDTO findByDisciplineName(@PathVariable Long disciplineId, @PathVariable String materialName)
            throws MaterialNotFoundException {
        return service.findByName(materialName);
    }

    @GetMapping("/disciplines/materials")
    public List<MaterialDTO> listAll() {
        return service.listAll();
    }
}
