package kodlamaio.rentACar.business.abstracts;

import kodlamaio.rentACar.business.requests.cars.CreateCarRequest;
import kodlamaio.rentACar.business.requests.cars.UpdateCarRequest;
import kodlamaio.rentACar.business.responses.cars.GetAllCarsResponse;
import kodlamaio.rentACar.business.responses.cars.GetByIdCarsResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll();
    GetByIdCarsResponse getById(int id);
    List<GetAllCarsResponse> findByPlateContains(String plate);
    void add(CreateCarRequest createCarRequest);
    void update(UpdateCarRequest updateCarRequest);
    void delete(int id);
}
