package kodlamaio.rentACar.business.abstracts;

import kodlamaio.rentACar.business.requests.models.CreateModelRequest;
import kodlamaio.rentACar.business.requests.models.UpdateModelRequest;
import kodlamaio.rentACar.business.responses.models.GetAllModelsResponse;
import kodlamaio.rentACar.business.responses.models.GetByIdModelsResponse;


import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    List<GetAllModelsResponse> getAll(int pageNo, int pageSize);
    GetByIdModelsResponse getById(int id);
    void add(CreateModelRequest createModelRequest);
    void update(UpdateModelRequest updateModelRequest);
    void delete(int id);
}
