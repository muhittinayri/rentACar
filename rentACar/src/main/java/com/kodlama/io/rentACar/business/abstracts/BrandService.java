package com.kodlama.io.rentACar.business.abstracts;

import com.kodlama.io.rentACar.business.requests.brands.CreateBrandRequest;
import com.kodlama.io.rentACar.business.requests.brands.UpdateBrandRequest;
import com.kodlama.io.rentACar.business.responses.brands.GetAllBrandsResponse;
import com.kodlama.io.rentACar.business.responses.brands.GetByIdBrandResponse;


import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    List<GetAllBrandsResponse> findByName(String name);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
