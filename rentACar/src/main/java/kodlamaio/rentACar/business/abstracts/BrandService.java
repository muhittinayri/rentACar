package kodlamaio.rentACar.business.abstracts;

import kodlamaio.rentACar.business.requests.brands.CreateBrandRequest;
import kodlamaio.rentACar.business.requests.brands.UpdateBrandRequest;
import kodlamaio.rentACar.business.responses.brands.GetAllBrandsResponse;
import kodlamaio.rentACar.business.responses.brands.GetByIdBrandResponse;


import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    List<GetAllBrandsResponse> findByName(String name);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
