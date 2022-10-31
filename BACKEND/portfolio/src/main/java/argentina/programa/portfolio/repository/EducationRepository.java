package argentina.programa.portfolio.repository;

import argentina.programa.portfolio.model.entity.AboutMe;
import argentina.programa.portfolio.model.entity.Education;
import argentina.programa.portfolio.model.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface EducationRepository extends JpaRepository<Education, Long>
{
    Set<Education> findAllById(Long id);

}
