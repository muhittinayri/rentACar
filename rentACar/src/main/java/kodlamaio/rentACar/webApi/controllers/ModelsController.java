package kodlamaio.rentACar.webApi.controllers;

import kodlamaio.rentACar.business.abstracts.ModelService;
import kodlamaio.rentACar.business.requests.models.CreateModelRequest;
import kodlamaio.rentACar.business.requests.models.UpdateModelRequest;
import kodlamaio.rentACar.business.responses.models.GetAllModelsResponse;
import kodlamaio.rentACar.business.responses.models.GetByIdModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {

    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdModelsResponse getById(@PathVariable() int id){
        return modelService.getById(id);
    }

    @GetMapping("/getAllPage")
    public List<GetAllModelsResponse> getAllPage(int pageNo, int pageSize){
        return this.modelService.getAll(pageNo, pageSize);
    }


    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody() UpdateModelRequest updateModelRequest){
        this.modelService.update(updateModelRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable() int id) {
        this.modelService.delete(id);
    }

}