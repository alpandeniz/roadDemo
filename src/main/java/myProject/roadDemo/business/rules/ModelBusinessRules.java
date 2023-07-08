package myProject.roadDemo.business.rules;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import myProject.roadDemo.core.utilities.exceptions.BusinessException;
import myProject.roadDemo.dataAccess.abstracts.ModelRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ModelBusinessRules {

    private final ModelRepository modelRepository;

    public void checkIfModelNameExists(String name)
    throws BusinessException{
        if (modelRepository.existsByName(name)){
            throw new BusinessException("Model already exists!");
        }
    }
}
