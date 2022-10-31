package argentina.programa.portfolio.repository;

import argentina.programa.portfolio.model.entity.AboutMe;
import argentina.programa.portfolio.model.entity.ContactInformation;
import argentina.programa.portfolio.model.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ContactInformationRepository extends JpaRepository<ContactInformation, Long>
{
    Set<ContactInformation> findAllById(Long id);

}
