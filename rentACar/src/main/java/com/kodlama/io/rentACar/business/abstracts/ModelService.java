package com.kodlama.io.rentACar.business.abstracts;

import com.kodlama.io.rentACar.business.requests.models.CreateModelRequest;
import com.kodlama.io.rentACar.business.requests.models.UpdateModelRequest;
import com.kodlama.io.rentACar.business.responses.models.GetAllModelsResponse;
import com.kodlama.io.rentACar.business.responses.models.GetByIdModelsResponse;
import org.springframework.data.domain.Page;


import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    List<GetAllModelsResponse> getAll(int pageNo, int pageSize);
    GetByIdModelsResponse getById(int id);
    void add(CreateModelRequest createModelRequest);
    void update(UpdateModelRequest updateModelRequest);
    void delete(int id);
}
