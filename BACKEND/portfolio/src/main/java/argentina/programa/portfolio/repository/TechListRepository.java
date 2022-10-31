package argentina.programa.portfolio.repository;

import argentina.programa.portfolio.model.entity.AboutMe;
import argentina.programa.portfolio.model.entity.TechnologiesList;
import argentina.programa.portfolio.model.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TechListRepository extends JpaRepository<TechnologiesList, Long>
{
    Set<TechListRepository> findAllById(Long id);

}
