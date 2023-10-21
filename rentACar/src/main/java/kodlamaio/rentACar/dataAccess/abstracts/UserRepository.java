package kodlamaio.rentACar.dataAccess.abstracts;

import kodlamaio.rentACar.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
