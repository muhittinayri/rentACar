package kodlamaio.rentACar.business.rules;

import kodlamaio.rentACar.core.utilities.exceptions.BusinessException;
import kodlamaio.rentACar.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ModelBusinessRules {
    private ModelRepository modelRepository;

    public void checkIfModelNameExists(String name){
        if (this.modelRepository.existsByName(name)){
            throw new BusinessException("Model name already exists");
        }
    }
}
