package kodlamaio.rentACar.business.concretes;

import kodlamaio.rentACar.business.abstracts.ModelService;
import kodlamaio.rentACar.business.requests.models.CreateModelRequest;
import kodlamaio.rentACar.business.requests.models.UpdateModelRequest;
import kodlamaio.rentACar.business.responses.models.GetAllModelsResponse;
import kodlamaio.rentACar.business.responses.models.GetByIdModelsResponse;
import kodlamaio.rentACar.business.rules.ModelBusinessRules;
import kodlamaio.rentACar.core.utilities.mappers.ModelMapperService;
import kodlamaio.rentACar.dataAccess.abstracts.ModelRepository;
import kodlamaio.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
