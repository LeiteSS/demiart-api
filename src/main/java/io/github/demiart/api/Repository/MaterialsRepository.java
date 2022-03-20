package io.github.demiart.api.Repository;

import io.github.demiart.api.Models.Material;
import io.github.demiart.api.Repository.model.MaterialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MaterialsRepository extends JpaRepository<Material, Long>
{
    Optional<Material> findByMaterialName(String materialName);

    @Query(value = "SELECT * FROM material_tb m, discipline_tb d WHERE m.id_discipline = :disciplineId AND d.discipline_id = :disciplineId", nativeQuery = true)
    List<MaterialModel> findByDisciplineId(Long disciplineId);
}
