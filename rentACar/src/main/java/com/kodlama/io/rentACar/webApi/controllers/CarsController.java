package com.kodlama.io.rentACar.webApi.controllers;

import com.kodlama.io.rentACar.business.abstracts.CarService;
import com.kodlama.io.rentACar.business.requests.cars.CreateCarRequest;
import com.kodlama.io.rentACar.business.requests.cars.UpdateCarRequest;
import com.kodlama.io.rentACar.business.responses.cars.GetAllCarsResponse;
import com.kodlama.io.rentACar.business.responses.cars.GetByIdCarsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {

    private CarService carService;

    @GetMapping()
    public List<GetAllCarsResponse> getAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdCarsResponse getById(@PathVariable() int id){
        return carService.getById(id);
    }

    @GetMapping("/plate")
    public List<GetAllCarsResponse> getByPlateName(@RequestParam() String plate){
        return carService.findByPlateContains(plate);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid()CreateCarRequest createCarRequest){
        this.carService.add(createCarRequest);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody()UpdateCarRequest updateCarRequest){
        this.carService.update(updateCarRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable() int id){
        this.carService.delete(id);
    }
}
