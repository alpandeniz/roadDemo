package myProject.roadDemo.business.concretes;

import myProject.roadDemo.core.utilities.exceptions.BusinessException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import myProject.roadDemo.business.abstracts.BrandService;
import myProject.roadDemo.business.rules.BrandBusinessRules;
import myProject.roadDemo.core.utilities.mappers.ModelMapperService;
import myProject.roadDemo.dataAccess.abstracts.BrandRepository;
import myProject.roadDemo.dto.requests.CreateBrandRequest;
import myProject.roadDemo.entities.concretes.Brand;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	private final BrandRepository brandRepository;
	private final ModelMapperService modelMapperService;
	private final BrandBusinessRules brandBusinessRules;
	@Override
	public void save(CreateBrandRequest createBrandRequest) {
		try {
			this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
			Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
			this.brandRepository.save(brand);
		}catch (Exception exception){
			exception.getMessage();
		}

	}

}
