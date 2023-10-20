package com.kodlama.io.rentACar.business.concretes;

import com.kodlama.io.rentACar.business.abstracts.BrandService;
import com.kodlama.io.rentACar.business.requests.brands.CreateBrandRequest;
import com.kodlama.io.rentACar.business.requests.brands.UpdateBrandRequest;
import com.kodlama.io.rentACar.business.responses.brands.GetAllBrandsResponse;
import com.kodlama.io.rentACar.business.responses.brands.GetByIdBrandResponse;
import com.kodlama.io.rentACar.business.rules.BrandBusinessRules;
import com.kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import com.kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import com.kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service  // Bu sınıf bir business nesnesidir.
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        //mapping
        List<Brand> brands =  brandRepository.findAll();
//        List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
//        for (Brand brand : brands) {
//            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//            responseItem.setId(brand.getId());
//            responseItem.setName(brand.getName());
//            brandsResponse.add(responseItem);
//        }

        List<GetAllBrandsResponse> brandsResponse = brands.stream().map(brand -> this.modelMapperService.forResponse()
                .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        //.collect(Collectors.toList()); -> topla ve toliste çevir anlamındadır.
        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public List<GetAllBrandsResponse> findByName(String name) {
        List<Brand> brands = brandRepository.findByName(name);
        List<GetAllBrandsResponse> response = brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
                .collect(Collectors.toList());
        return response;
    }


    @Override
    public void add(CreateBrandRequest createBrandRequest) {

        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());  //iş kuralı

//      Brand brand = new Brand();
//      brand.setName(createBrandRequest.getName());

        //mapper kullanımı -> mapper kullanılmazsa yukarıdaki kod gibi tek tek eşitlemek gerekiyor.
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
