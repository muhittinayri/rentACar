package com.kodlama.io.rentACar.dataAccess.abstracts;

import com.kodlama.io.rentACar.business.responses.brands.GetAllBrandsResponse;
import com.kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BrandRepository extends JpaRepository<Brand, Integer>{
    boolean existsByName(String name);
    List<Brand> findByName(String name);
}