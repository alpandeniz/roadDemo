package myProject.roadDemo.core.rules;

import lombok.RequiredArgsConstructor;
import myProject.roadDemo.core.exceptions.BusinessException;
import myProject.roadDemo.vehicle.repository.VehicleRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ModelBusinessRules {

    private final VehicleRepository vehicleRepository;

    public void checkIfModelNameExists(String name)
    throws BusinessException{
        if (vehicleRepository.existsByName(name)){
            throw new BusinessException("Model already exists!");
        }
    }
}
