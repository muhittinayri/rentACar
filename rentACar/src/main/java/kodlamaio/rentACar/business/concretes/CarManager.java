package kodlamaio.rentACar.business.concretes;

import kodlamaio.rentACar.business.abstracts.CarService;
import kodlamaio.rentACar.business.requests.cars.CreateCarRequest;
import kodlamaio.rentACar.business.requests.cars.UpdateCarRequest;
import kodlamaio.rentACar.business.responses.cars.GetAllCarsResponse;
import kodlamaio.rentACar.business.responses.cars.GetByIdCarsResponse;
import kodlamaio.rentACar.core.utilities.mappers.ModelMapperService;
import kodlamaio.rentACar.dataAccess.abstracts.CarRepository;
import kodlamaio.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private CarRepository carRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetAllCarsResponse> carsResponse = cars.stream().map(car -> this.modelMapperService.forResponse()
                .map(car, GetAllCarsResponse.class)).collect(Collectors.toList());
        return carsResponse;
    }

    @Override
    public GetByIdCarsResponse getById(int id) {
        Car car = this.carRepository.findById(id).orElseThrow();
        GetByIdCarsResponse response = this.modelMapperService.forResponse().map(car, GetByIdCarsResponse.class);
        return response;
    }

    @Override
    public List<GetAllCarsResponse> findByPlateContains(String plate) {
        List<Car> cars = this.carRepository.findByPlateContains(plate);
        List<GetAllCarsResponse> response = cars.stream().map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
                .collect(Collectors.toList());
        return response;
    }

    @Override
    public void add(CreateCarRequest createCarRequest) {
        Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
        car.setId(0);
        this.carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
        this.carRepository.save(car);
    }

    @Override
    public void delete(int id) {
        this.carRepository.deleteById(id);
    }
}
