package argentina.programa.portfolio.repository;

import argentina.programa.portfolio.model.entity.AboutMe;
import argentina.programa.portfolio.model.entity.Project;
import argentina.programa.portfolio.model.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ProjectRepository extends JpaRepository<Project, Long>
{
    Set<Project> findAllById(Long id);

}
