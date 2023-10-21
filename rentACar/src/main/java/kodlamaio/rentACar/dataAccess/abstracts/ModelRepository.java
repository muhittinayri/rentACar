package kodlamaio.rentACar.dataAccess.abstracts;

import kodlamaio.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ModelRepository extends JpaRepository<Model, Integer>{
    boolean existsByName(String name);
}
