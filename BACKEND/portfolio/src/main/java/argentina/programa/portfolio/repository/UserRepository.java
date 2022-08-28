package argentina.programa.portfolio.repository;

import argentina.programa.portfolio.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

     User findByEmail(String email);
}
