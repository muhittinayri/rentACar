package com.kodlama.io.rentACar.business.concretes;

import com.kodlama.io.rentACar.business.abstracts.ModelService;
import com.kodlama.io.rentACar.business.requests.models.CreateModelRequest;
import com.kodlama.io.rentACar.business.requests.models.UpdateModelRequest;
import com.kodlama.io.rentACar.business.responses.models.GetAllModelsResponse;
import com.kodlama.io.rentACar.business.responses.models.GetByIdModelsResponse;
import com.kodlama.io.rentACar.business.rules.ModelBusinessRules;
import com.kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import com.kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import com.kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    private ModelBusinessRules modelBusinessRules;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models =  modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponse = models.stream().map(model -> this.modelMapperService.forResponse()
                .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponse;
    }

    @Override
    public List<GetAllModelsResponse> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        Page<Model> models = modelRepository.findAll(pageable);
        return models.map(model -> modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).getContent();
    }

    @Override
    public GetByIdModelsResponse getById(int id) {
        Model model = this.modelRepository.findById(id).orElseThrow();
        GetByIdModelsResponse response = this.modelMapperService.forResponse().map(model, GetByIdModelsResponse.class);
        return response;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        this.modelBusinessRules.checkIfModelNameExists(createModelRequest.getName());
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        model.setId(0);
        this.modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {
        Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
        this.modelRepository.save(model);
    }

    @Override
    public void delete(int id) {
        this.modelRepository.deleteById(id);
    }
}
