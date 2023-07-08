package myProject.roadDemo.core.rules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import myProject.roadDemo.core.exceptions.BusinessException;
import myProject.roadDemo.vehicle.repository.BrandRepository;

@AllArgsConstructor
@Service
public class BrandBusinessRules {

	private final BrandRepository brandRepository;

	public void checkIfBrandNameExists(String name)
			throws BusinessException
	{
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessException("Brand already exists!");
		}
	}
}
