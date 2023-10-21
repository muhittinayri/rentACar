package kodlamaio.rentACar.dataAccess.abstracts;

import kodlamaio.rentACar.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByPlateContains(String plate);
}
