package argentina.programa.portfolio.repository;

import argentina.programa.portfolio.model.entity.AboutMe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutMeRepository extends JpaRepository<AboutMe, Long>
{
}
