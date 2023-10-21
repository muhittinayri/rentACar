package kodlamaio.rentACar.webApi.controllers;

import kodlamaio.rentACar.business.abstracts.BrandService;
import kodlamaio.rentACar.business.requests.brands.CreateBrandRequest;
import kodlamaio.rentACar.business.requests.brands.UpdateBrandRequest;
import kodlamaio.rentACar.business.responses.brands.GetAllBrandsResponse;
import kodlamaio.rentACar.business.responses.brands.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable  int id){
        return brandService.getById(id);
    }

    @GetMapping("/name")
    public List<GetAllBrandsResponse> findByName(@RequestParam() String name){
        return brandService.findByName(name);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody() UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }

}

