package argentina.programa.portfolio.repository;

import argentina.programa.portfolio.model.entity.AboutMe;
import argentina.programa.portfolio.model.entity.Experience;
import argentina.programa.portfolio.model.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ExperienceRepository extends JpaRepository<Experience, Long>
{
    Set<Experience> findAllById(Long id);

}
