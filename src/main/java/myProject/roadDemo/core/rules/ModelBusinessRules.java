package myProject.roadDemo.core.rules;

import lombok.RequiredArgsConstructor;
import myProject.roadDemo.core.exceptions.BusinessException;
import myProject.roadDemo.vehicle.repository.ModelRepository;
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
