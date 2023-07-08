package myProject.roadDemo.business.rules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import myProject.roadDemo.core.utilities.exceptions.BusinessException;
import myProject.roadDemo.dataAccess.abstracts.BrandRepository;

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
