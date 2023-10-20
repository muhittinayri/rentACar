package com.kodlama.io.rentACar.dataAccess.abstracts;

import com.kodlama.io.rentACar.business.responses.models.GetAllModelsResponse;
import com.kodlama.io.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ModelRepository extends JpaRepository<Model, Integer>{
    boolean existsByName(String name);
}
