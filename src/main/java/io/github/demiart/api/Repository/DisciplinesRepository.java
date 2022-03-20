package io.github.demiart.api.Repository;

import io.github.demiart.api.Models.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisciplinesRepository extends JpaRepository<Discipline, Long>
{
    Optional<Discipline> findByDisciplineName(String disciplineName);
}
